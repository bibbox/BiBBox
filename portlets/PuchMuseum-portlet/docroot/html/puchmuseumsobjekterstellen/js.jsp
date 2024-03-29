<link rel="stylesheet" type="text/css" href="/js/bwip/lib/demo.css">
<link rel="stylesheet" type="text/css" href="/js/bwip/lib/jquery-ui.min.css">
<script type="text/javascript" src="/js/bwip/lib/jquery.js"></script>
<script type="text/javascript" src="/js/bwip/lib/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/bwip/lib/fonts.js"></script>
<script type="text/javascript" src="/js/bwip/lib/filedrop-min.js"></script>
<script type="text/javascript">
var Module = {
		// memoryInitializerPrefixURL:'your-path-here/',
		preRun:[ function() {
				Module.FS_createPreloadedFile("/", "Inconsolata.otf",
											 "Inconsolata.otf", true, false);
		} ],
		postRun:[ function() {
				var load_font = Module.cwrap("load_font", 'number',
											['string','string','number']);
				load_font("Inconsolata.otf", "INCONSOLATA", 108);

				// Load any previously saved fonts
				for (var i = 0; i < 8; i++) {
					if (!localStorage.getItem('bwipjsFontName' + i))
						continue;

					var fontname = localStorage.getItem('bwipjsFontName' + i);
					var filename = localStorage.getItem('bwipjsFileName' + i);
					var sizemult = localStorage.getItem('bwipjsSizeMult' + i);
					var fontfile = atob(localStorage.getItem('bwipjsFontFile' + i));
					try {
						fontLoad(fontname, filename, sizemult, fontfile);
						fontShow(fontname, filename, sizemult);
					} catch (e) {
						alert('Error: ' + fontname + ': ' + filename + ': ' + e);

						localStorage.removeItem('bwipjsFontName' + i);
						localStorage.removeItem('bwipjsFileName' + i);
						localStorage.removeItem('bwipjsSizeMult' + i);
						localStorage.removeItem('bwipjsFontFile' + i);
					}
				}
		} ]
	};
	</script>
	<script type="text/javascript" src="/js/bwip/freetype.js"></script>
	<script type="text/javascript" src="/js/bwip/bwip.js"></script>
	<script type="text/javascript" src="/js/bwip/lib/canvas.js"></script>
	<script type="text/javascript" src="/js/bwip/lib/symdesc.js"></script>
	<script type="text/javascript" src="/js/bwip/lib/canvas-toblob.js"></script>
	<script type="text/javascript" src="/js/bwip/lib/filesaver.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		var lastSymbol;
		try {
			lastSymbol = localStorage.getItem('bwipjsLastSymbol');
		} catch (e) {
		}

		var $sel = $('#symbol')
			.change(function(ev) {
				var desc = symdesc[$(this).val()];
				if (desc) {
					$('#symtext').val(desc.text);
					$('#symopts').val(desc.opts);

					$('#proof-img').css('visibility', 'hidden');

					try {
						localStorage.setItem('bwipjsLastSymbol', desc.sym);
					} catch (e) {
					}
				} else {
					$('#symtext').val('');
					$('#symopts').val('');
				}
				$('#symaltx').val('');
				$('.saveas').css('visibility', 'hidden');
			});

		if (lastSymbol)
			$sel.val(lastSymbol);
		else 
			$sel.prop('selectedIndex', 0);
		$sel.trigger('change');

		$('#scaleX').spinner({ min:1 })
			.on("spinstop", function(ev) {
				$('#scaleY').val(this.value);
			});
		$('#scaleY').spinner({ min:1 });
		$('#render').button().click(render);
		$('#fonthdr').click(fontClick);
		$('#addfont').button().click(fontRead);
		$('.saveas').css('visibility', 'hidden');

		if (location.search.indexOf('proofs=1') != -1) { 
			// Show the images from BWIPP with Ghostscript
			var img = document.createElement('img');
			img.id					= 'proof-img';
			img.style.visibility 	= 'hidden';
			img.style.position		= 'absolute';
			img.style.top			= '0px';
			img.style.left			= '0px';
			$('#proof').append(img);
		}

		// File picker
		var zone = new FileDrop('dropzone');
		zone.event('send', function (files) {
			var file = files.first();
			$('#dropzone div.droptext').css('display', 'none');
			$('#dropzone div.dropfile').css('display', 'block').text(file.name);
			$('#dropzone input.fd-file')[0].title = file.name;

			fontSelected(file.nativeFile);		// Native browser File object
		});

		// Allow Enter to render
		$('#params').keypress(function(ev) {
			if (ev.which == 13) {
				render();
				ev.stopPropagation();
				ev.preventDefault();
				return false;
			}
		});
	});

	function render() {
		var elt  = symdesc[$('#symbol').val()];
		var text = $('#symtext').val().replace(/^\s+/,'').replace(/\s+$/,'');
		var altx = $('#symaltx').val().replace(/^\s+/,'').replace(/\s+$/,'');
		var opts = $('#symopts').val().replace(/^\s+/,'').replace(/\s+$/,'');

		var bw = new BWIPJS;

		$('#proof-img').css('visibility', 'hidden');
		$('.saveas').css('visibility', 'hidden');

		// Convert the options to a dictionary object, so we can pass alttext with
		// spaces.
		var tmp = opts.split(' '); 
		opts = {};
		for (var i = 0; i < tmp.length; i++) {
			if (!tmp[i])
				continue;
			var eq = tmp[i].indexOf('=');
			if (eq == -1)
				opts[tmp[i]] = bw.value(true);
			else
				opts[tmp[i].substr(0, eq)] = bw.value(tmp[i].substr(eq+1));
		}

		// Add the alternate text
		if (altx)
			opts.alttext = bw.value(altx);

		var rot  = 'N';
		var rots = [ 'rotL', 'rotR', 'rotI' ];
		for (var i = 0; i < rots.length; i++) {
			if (document.getElementById(rots[i]).checked) {
				rot = rots[i].charAt(3);
				break;
			}
		}

		// Anti-aliased or monochrome fonts?
		// This hooks directly into the FreeType library.
		BWIPJS.ft_monochrome(document.getElementById('fontAnti').checked ? 0 : 1);

		// Feature or bug, BWIPP does not extend the background color into the
		// human readable text.  Fix that in the bitmap interface.
		if (opts.backgroundcolor) {
			bw.bitmap(new Bitmap('#' + opts.backgroundcolor));
			delete opts.backgroundcolor;
		} else {
			bw.bitmap(new Bitmap);
		}
		
		var scaleX = +document.getElementById('scaleX').value || 2;
		var scaleY = +document.getElementById('scaleY').value || 2;
		bw.scale(scaleX, scaleY);

		var div = document.getElementById('output');
		if (div)
			div.innerHTML = '';

		bw.push(text);
		bw.push(opts);

		bw.call(elt.sym, function(e) {
				if (e) {
					if (typeof e === 'string') {
						alert(e);
					} else if (e.stack) {
						alert(e.message + '\r\n' + e.stack);
					} else {
						var s = '';
						if (e.fileName)
							s += e.fileName + ' ';
						if (e.lineNumber)
							s += '[line ' + e.lineNumber + '] ';
						alert(s + (s ? ': ' : '') + e.message);
					}
				} else {
					bw.bitmap().show('canvas', rot);

					$('.saveas').css('visibility', 'visible');
					saveCanvas.basename = elt.sym + '-' +
							text.replace(/[^a-zA-Z0-9._]+/g, '-');

					if (location.search.indexOf('proofs=1') != -1) { 
						var img = document.getElementById('proof-img');
						if (img) {
							img.src = 'proofs/' + elt.sym + '.png';
							img.style.visibility = 'visible';
						}
					}
				}
			});
	}
	function saveCanvas(type, ext) {
		var canvas = document.getElementById('canvas');
		canvas.toBlob(function (blob) {
						  saveAs(blob, saveCanvas.basename + ext);
					  }, type, 1);
	}
	</script>

	<div id="header">
		<div id="bwipjs">bwip-js // Barcode Writer in Pure JavaScript</div>
		<div id="fonthdr">&#x25bc; Fonts</div>
		<div id="fontdiv" style="visibility:hidden">
			<div class="inner">
				PostScript Name of Font:<br>
				<input type="text" id="fontname" style="width:32ex"><br>
				<br>
				Font Size Multiplier (100 = 100%):<br>
				<input type="text" id="fontmult" style="width:6ex" value="100"><br>
				<br>
				<div id="dropzone">
					<div class="content">
						<div class="droptext">Drop file here or click to select.</div>
						<div class="dropfile" style="display:none"></div>
					</div>
				</div>
				<br>
				<button id="addfont">Add Font</button><br>
				<div id="fontlist" class="empty"></div>
			</div>
		</div>
	</div>
	<div id="params">
	<table border=0 cellpading=0 cellspacing=0><tr>
	<td>
		<table border=0 cellpading=0 cellspacing=0>
		<tr><th>Barcode Type:
			<td><select id="symbol" style="width:63.5ex">
				<option value="auspost">AusPost 4 State Customer Code</option>
				<option value="azteccode">Aztec Code</option>
				<option value="aztecrune">Aztec Runes</option>
				<option value="bc412">BC412</option>
				<option value="channelcode">Channel Code</option>
				<option value="rationalizedCodabar">Codabar</option>
				<option value="codablockf">Codablock F</option>
				<option value="code11">Code 11</option>
				<option value="code128">Code 128</option>
				<option value="code16k">Code 16K</option>
				<option value="code2of5">Code 25</option>
				<option value="code39">Code 39</option>
				<option value="code39ext">Code 39 Extended</option>
				<option value="code49">Code 49</option>
				<option value="code93">Code 93</option>
				<option value="code93ext">Code 93 Extended</option>
				<option value="codeone">Code One</option>
				<option value="azteccodecompact">Compact Aztec Code</option>
				<option value="pdf417compact">Compact PDF417</option>
				<option value="coop2of5">COOP 2 of 5</option>
				<option value="raw">Custom 1D symbology</option>
				<option value="daft">Custom 4 state symbology</option>
				<option value="datamatrix">Data Matrix</option>
				<option value="datalogic2of5">Datalogic 2 of 5</option>
				<option value="identcode">Deutsche Post Identcode</option>
				<option value="leitcode">Deutsche Post Leitcode</option>
				<option value="ean13">EAN-13</option>
				<option value="ean13composite">EAN-13 Composite</option>
				<option value="ean2">EAN-2 (2 digit addon)</option>
				<option value="ean5">EAN-5 (5 digit addon)</option>
				<option value="ean8">EAN-8</option>
				<option value="ean8composite">EAN-8 Composite</option>
				<option value="flattermarken">Flattermarken</option>
				<option value="gs1-cc">GS1 Composite 2D Component</option>
				<option value="gs1datamatrix">GS1 Data Matrix</option>
				<option value="databarexpanded">GS1 DataBar Expanded</option>
				<option value="databarexpandedcomposite">GS1 DataBar Expanded Composite</option>
				<option value="databarexpandedstacked">GS1 DataBar Expanded Stacked</option>
				<option value="databarexpandedstackedcomposite">GS1 DataBar Expanded Stacked Composite</option>
				<option value="databarlimited">GS1 DataBar Limited</option>
				<option value="databarlimitedcomposite">GS1 DataBar Limited Composite</option>
				<option value="databaromni">GS1 DataBar Omnidirectional</option>
				<option value="databaromnicomposite">GS1 DataBar Omnidirectional Composite</option>
				<option value="databarstacked">GS1 DataBar Stacked</option>
				<option value="databarstackedcomposite">GS1 DataBar Stacked Composite</option>
				<option value="databarstackedomni">GS1 DataBar Stacked Omnidirectional</option>
				<option value="databarstackedomnicomposite">GS1 DataBar Stacked Omnidirectional Composite</option>
				<option value="databartruncated">GS1 DataBar Truncated</option>
				<option value="databartruncatedcomposite">GS1 DataBar Truncated Composite</option>
				<option value="gs1qrcode">GS1 QR Code</option>
				<option value="gs1-128">GS1-128</option>
				<option value="gs1-128composite">GS1-128 Composite</option>
				<option value="ean14">GS1-14</option>
				<option value="hibccodablockf">HIBC Codablock F</option>
				<option value="hibccode128">HIBC Code 128</option>
				<option value="hibccode39">HIBC Code 39</option>
				<option value="hibcdatamatrix">HIBC Data Matrix</option>
				<option value="hibcmicropdf417">HIBC MicroPDF417</option>
				<option value="hibcpdf417">HIBC PDF417</option>
				<option value="hibcqrcode">HIBC QR Code</option>
				<option value="iata2of5">IATA 2 of 5</option>
				<option value="industrial2of5">Industrial 2 of 5</option>
				<option value="interleaved2of5">Interleaved 2 of 5 (ITF)</option>
				<option value="isbn">ISBN</option>
				<option value="ismn">ISMN</option>
				<option value="issn">ISSN</option>
				<option value="code32">Italian Pharmacode</option>
				<option value="itf14">ITF-14</option>
				<option value="japanpost">Japan Post 4 State Customer Code</option>
				<option value="matrix2of5">Matrix 2 of 5</option>
				<option value="maxicode">MaxiCode</option>
				<option value="microqrcode">Micro QR Code</option>
				<option value="micropdf417">MicroPDF417</option>
				<option value="symbol">Miscellaneous symbols</option>
				<option value="msi">MSI Modified Plessey</option>
				<option value="pdf417">PDF417</option>
				<option value="pharmacode">Pharmaceutical Binary Code</option>
				<option value="pzn">Pharmazentralnummer (PZN)</option>
				<option value="plessey">Plessey UK</option>
				<option value="posicode">PosiCode</option>
				<option value="qrcode">QR Code</option>
				<option value="kix">Royal Dutch TPG Post KIX</option>
				<option value="royalmail">Royal Mail 4 State Customer Code</option>
				<option value="sscc18">SSCC-18</option>
				<option value="telepen">Telepen</option>
				<option value="telepennumeric">Telepen Numeric</option>
				<option value="pharmacode2">Two-track Pharmacode</option>
				<option value="upca">UPC-A</option>
				<option value="upcacomposite">UPC-A Composite</option>
				<option value="upce">UPC-E</option>
				<option value="upcecomposite">UPC-E Composite</option>
				<option value="onecode">USPS Intelligent Mail</option>
				<option value="planet">USPS PLANET</option>
				<option value="postnet">USPS POSTNET</option>
				</select>
		<tr><th>Bar Text:<td><input id="symtext" type="text" style="width:63ex">
		<tr><th>Alt Text:<td><input id="symaltx" type="text" style="width:63ex">
		<tr><th>Options:<td><input id="symopts" type="text" style="width:63ex">
		<tr><td><td>
			<a class="saveas" href="javascript:saveCanvas('image/png','.png')">Save As PNG</a>
			&nbsp;&nbsp;
			<a class="saveas" href="javascript:saveCanvas('image/jpeg','.jpg')">Save As JPEG</a>
			&nbsp;&nbsp;
		</table>
	<td style="padding-left:10mm">
		<table border=0 cellpading=0 cellspacing=5>
		<tr><th>Scale X,Y:<td>
			<input type="text" id="scaleX" value=2>
			<input type="text" id="scaleY" value=2>
		<tr><th>Image Rotation:<td>
			<label for="rotN"><input type="radio" name="rot" value="N"
				id="rotN" checked>Normal</label>
			<label for="rotR"><input type="radio" name="rot" value="R"
				id="rotR">90 CW</label>
			<label for="rotL"><input type="radio" name="rot" value="L"
				id="rotL">90 CCW</label>
			<label for="rotI"><input type="radio" name="rot" value="I"
				id="rotI">180</label>
		<tr><th>Font Rendering:<td>
			<label for="fontAnti"><input type="radio" name="font" value="A"
				id="fontAnti" checked>Anti-Aliased</label>
			<label for="fontMono"><input type="radio" name="font" value="M"
				id="fontMono">Monochrome</label>
		<tr><td><td><button id="render">Show Barcode</button>
		</table>
	<tr><td><br>
	</table>
	</div>
	<div id="content">
	<canvas id="canvas" width=1 height=1 style="border:1px solid #fff;visibility:hidden"></canvas>
	<div id="proof" style="position:relative;border:1px solid #fff"></div>
	<div id="output" style="white-space:pre"></div>
	</div>
