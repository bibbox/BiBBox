<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

<%
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	long organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	String az = organization.getExpandoBridge().getAttribute("aznummer").toString();
  	String male = organization.getExpandoBridge().getAttribute("male").toString();
  	String date_ = organization.getExpandoBridge().getAttribute("dateofbirth").toString();
  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  	Date dateofbirth = dateFormat.parse(date_);
  	Date now = new Date();
  	long calc = now.getTime() - dateofbirth.getTime();
  	long MILLS_IN_YEAR = 1000L * 60 * 60 * 24 * 365;
  	long age = calc/MILLS_IN_YEAR;
  	String name = organization.getExpandoBridge().getAttribute("firstname").toString() + " " + organization.getExpandoBridge().getAttribute("lastname").toString() + " (" + organization.getExpandoBridge().getAttribute("dateofbirth").toString() + ")";
  	
	%>

<table>
<tr><td>Kontakt: <%= themeDisplay.getUser().getFullName() %></td><td>Serviceunterlage</td></tr>
<tr><td>Letzte Änderung:</td><td>FB<%= az %></td></tr>
</table>
<br>
<div style="margin: auto;width: 100%;text-align: center;">
<h1>PatientInneninformation/Einverständniserklärung</h1><br>
<h3>für die Diagnostik und Forschungsvorhaben der Medizinischen Universität Graz</h3><br><br>
</div>
<b>Bereitstellung von Gewebsproben, Blutproben und anderen Körperflüssigkeiten zu Forschungszwecken und zur Entwicklung neuer Diagnoseverfahren, Vorbeugemaßnahmen und Behandlungen </b><br><br>

Sehr geehrte Patientin! Sehr geehrter Patient!<br> <br>

<u>Einleitung</u><br>

Die wissenschaftliche Untersuchung von Gewebsproben, Blutproben und anderen Körperflüssigkeiten in Verbindung mit Krankheitssymptomen ist heute eine der wichtigsten Voraussetzungen für ein besseres Verständnis der Ursachen und des Verlaufs von Erkrankungen sowie für die darauf aufbauende Entwicklung neuer Verfahren für die Diagnose, Vorbeugung und Behandlung dieser Erkrankungen. Hierfür werden typischerweise aus medizinischen Proben Zellen oder andere Bestandteileisoliert, vermehrt und mit mikroskopischen, biochemischen, immunologischen oder molekularbiologischen Methoden untersucht. Auch genanalytische Methoden können dabei zum Einsatz kommen. (Alle diese Methoden sind wissenschaftliche Techniken, mit denen die verschiedenen chemischen und biologischen Vorgänge im menschlichen Körper bzw. in dessen Zellen erforscht und besser verstanden werden.) Solche Untersuchungen sind nur möglich, wenn Patientinnen und Patienten sich bereit erklären, medizinische Probenhierfür zur Verfügung zu stellen.<br> 
<br>
<b>Wir laden Sie ein, an dem oben genannten Forschungsvorhaben teilzunehmen. Voraussetzung für die Durchführung dieser Forschung ist, dass Sie Ihr Einverständnis zur Teilnahme schriftlich erklären. Bitte lesen Sie den folgenden Text als Ergänzung zu einem ausführlichen Gespräch mit Fachleuten sorgfältig durch und zögern Sie nicht, Fragen zu stellen. </b><br>
<br>
<u>Maßnahmen im Rahmen des Forschungsprojektes:</u>
<ul>
<li>
Sollten bei den ohnehin vorgesehenen Untersuchungen im Rahmen der Diagnose und Behandlung Ihrer Erkrankung Blutproben, andere Körperflüssigkeiten oder Gewebsproben gewonnen werden, ist geplant, jene Anteile dieser medizinischen Proben, welche nicht mehr unmittelbar für Ihre medizinische Betreuung benötigt werden, ohne zeitliche Befristung in einer sogenannten Biobank zu sammeln, zu archivieren und in Verbindung mit den erhobenen Krankheitsdaten für die Forschung zu verwenden. Diese Biobank ist Eigentum der Medizinischen Universität Graz und firmenunabhängig.<br>
Es wird bei Ihnen keinesfalls mehr oder anderes Gewebe entfernt, als für die Diagnose beziehungsweise Therapie der bei Ihnen vorliegenden Erkrankung erforderlich ist. Für etwaige zusätzliche Eingriffe im Rahmen von anderen wissenschaftlichen Projekten der medizinischen Universität Graz werden sie gesondert darüber informiert.<br>
Lediglich im Rahmen von routinemäßig vorgesehenen Blutabnahmen könnte Ihnen bis maximal 20 ml Blut zusätzlich entnommen werden. 
</li>
<li>
Um Zusammenhänge zwischen den Forschungsergebnissen und Ihrer Erkrankung feststellen zu können, dürfen gegebenenfalls von der Medizinischen Universität Graz Informationen über den Verlauf Ihrer Erkrankung von Ihrem Hausarzt, dem Sie betreuenden Facharzt, oder anderen Krankenhäusern, an denen Sie behandelt werden, eingeholt werden. 
</li>
<li>
Die Forschungsergebnisse werden gemeinsam mit den Daten über den Verlauf Ihrer Erkrankung in kodierter Form in einer Datenbank gespeichert. Ebenso werden die Proben kodiert aufbewahrt. Unter kodiert wird verstanden, dass nach menschlichem Ermessen mit Ausnahme der Sie behandelnden Ärztinnen und Ärzte und des unmittelbar befassten Personals der Biobank keine dritte Person die medizinischen Proben, Ihre Befunde sowie die Angaben über Ihre Krankheitssymptome und Lebensumstände mit Ihnen in Verbindung bringen kann. Alle Personen, die Zugang zu diesen Proben und Daten haben, unterliegen der Schweigepflicht. Der Schutz vor dem Zugriff Unbefugter ist sichergestellt. <br>
Die Verantwortung für die Aufbewahrung bzw. gegebenenfalls Vernichtung der Daten und Proben trägt die Leiterin bzw. der Leiter der Biobank der Medizinischen Universität Graz. 
</li>
<li>
Die Forschung wird grundsätzlich an der Medizinischen Universität Graz bzw. in Zusammenarbeit mit anderen Forschungseinrichtungen erfolgen. Die Durchführung von Analysen an kodierten Proben oder kodierten Daten kann auch in nationaler und internationaler Zusammenarbeit mit externen Partnern (zB anderen Forschungseinrichtungen, Firmen) erfolgen. 
</li>
<li>
Ihre medizinischen Proben und Daten sollen zu wissenschaftlichen Erkenntnissen über Ursachen, Verlauf, Behandlung und Vorbeugung von Krankheiten führen und schließlich zur Entwicklung und Qualitätskontrolle von neuen Diagnosemitteln und verfahren eingesetzt werden.<br>
Gegebenenfalls sollen die Forschungsergebnisse in kodierter Form in wissenschaftlichen Schriften publiziert werden, zur Ausbildung von Ärztinnen und Ärzten eingesetzt werden und durch die Medizinische Universität Graz oder in Zusammenarbeit mit anderen Unternehmen und Personen weiter wissenschaftlich oder auch kommerziell, zB mittels Patentierung, verwertet werden. 
</li>
</ul>
Für Ihre Bereitstellung der medizinischen Proben, Befunde sowie die Angaben über Ihre Krankheitssymptome und Lebensumstände ist keine finanzielle Abgeltung oder Beteiligung an einer etwaigen kommerziellen Verwertung der Forschungsergebnisse vorgesehen. <br>

Eine individuelle Rückmeldung von Informationen und Forschungsergebnissen, die aus Ihren medizinischen Proben gewonnen werden, ist nur für den Fall vorgesehen, dass es sich um für Sie medizinisch bedeutsame Informationen handelt. Sie können jedoch darüber entscheiden, ob Sie diese Informationen bekommen möchten oder nicht. <br>

Das wissenschaftliche Vorhaben und diese PatientInnen-information/ Einverständniserklärung wurden von der zuständigen Ethikkommission geprüft und befürwortet. <br>

Forschungsprojekte, die in Zukunft mit den in der Biobank gespeicherten Proben und/oder Daten vorgesehen sind, werden erst nach Vorliegen einer neuerlichen, projektbezogenen befürwortenden Stellungnahme der Ethikkommission durchgeführt werden. Nur kodierte Proben und kodierte Daten werden von der Biobank an Forschungsprojekte weitergegeben. <br>


Ihre Einwilligung dazu ist völlig freiwillig und hat keinen Einfluss auf die für Sie vorgesehene Diagnose und Behandlung Ihrer Erkrankung. Durch die Teilnahme an diesem Forschungsvorhaben entstehen für Sie keine zusätzlichen Kosten. Sie können die Einwilligung ohne Angabe von Gründen ablehnen oder Ihre erteilte Einwilligung jederzeit ohne Angabe von Gründen durch schriftliche oder mündliche Erklärung widerrufen. In diesem Fall wird jegliche Verbindung zwischen den von Ihnen gewonnenen Proben sowie Daten und Ihrer Person unwieder bringlich gelöscht. Wenn Sie es wünschen, werden die Proben aus der Biobank entfernt und vernichtet. Für weitere Informationen oder den Widerruf der Einwilligung wenden Sie sich bitte an die Leitung der Biobank der Medizinischen Universität Graz, Stiftingtalstraße 24, A-8010 Graz (Tel. 0316-385-72716). <br>

<b>Bitte unterschreiben Sie die Einverständiserklärung nur:</b> 
<ul>
<li>wenn Sie Art und Ablauf des Forschungsvorhabens vollständig verstanden haben,</li>
<li>wenn Sie bereit sind, der Teilnahme zuzustimmen, und</li>
<li> wenn Sie sich über Ihre Rechte als Teilnehmerin bzw. Teilnehmer an diesem Forschungsvorhabens im Klaren sind.</li>
</ul>

<h2>Einverständniserklärung</h2>

Ich, <b><%= organization.getExpandoBridge().getAttribute("firstname").toString() + " " + organization.getExpandoBridge().getAttribute("lastname").toString() %></b> geboren am  
<b><%= dateFormat.format(dateofbirth) %></b> habe die mir zur Kenntnis gebrachte PatientInneninformation zum Forschungsvorhaben: &quot;Bereitstellung von Gewebsproben, Blutproben und anderen Körperflüssigkeiten zu Forschungszwecken und zur Entwicklung neuer Diagnoseverfahren, Vorbeugemaßnahmen und Behandlungen&quot;, bestehend aus 3 Seiten, gelesen und verstanden. <br>

Ich wurde im Rahmen eines diesbezüglichen Aufklärungsgespräches von Herrn/Frau (Dr. med.) <%= themeDisplay.getUser().getFullName() %> führlich und verständlich über Wesen, Bedeutung und Tragweite des Forschungsvorhabens informiert. Alle meine Fragen wurden ausreichend beantwortet und ich hatte ausreichend Zeit, mich zu entscheiden. Zur Zeit habe ich keine weiteren Fragen mehr.<br>

Mit meiner Unterschrift erkläre ich zu den angeführten Punkten Folgendes:<br>
<br>
<div style="border: 1px solid;padding:10px;">
Ich willige ein, dass ich die <b>nicht mehr für meine medizinische Behandlung benötigten Proben</b> der Medizinischen Universität Graz für das vorliegende Forschungsvorhaben überlasse.<br>
Ich erkläre mich bereit, dass <b>im Rahmen von routinemäßig vorgesehenen Blutabnahmen maximal 20 ml Blut zusätzlich</b> abgenommen werden können.<br>
</div><br>
Weiters erlaube ich der Medizinischen Universität Graz die Verwendung der für mich erstellten Befunde und der gesammelten Angaben über meine Krankheitssymptome und Lebensumstände für das vorliegende Forschungsvorhaben. Dies inkludiert neben den Daten, die am LKH/Univ. Klinikum vorhanden sind, auch medizinische Daten weiterer Institutionen (Haus-, Facharzt und andere Krankenhäuser), die zu diagnostischen oder therapeutischen Zwecken erhoben wurden.<br>
<br><div style="border: 1px solid;padding:10px;">
Ich bevollmächtige diesbezüglich die Medizinische Universität Graz, diese Daten direkt bei den genannten Institutionen anzufordern.
</div><br>
Beim Umgang mit den Proben und/oder Daten werden die Bestimmungen des Datenschutzgesetzes und des Gentechnikgesetzes beachtet. Bei allfälliger Weitergabe der Proben und/oder Daten sowie bei etwaigen Veröffentlichungen der Daten dieses Forschungsvorhabens werde ich nicht namentlich genannt.<br>
Eine Kopie dieser PatientInneninformation und Einverständniserklärung habe ich erhalten. Das Original verbleibt bei der Medizinischen Universität Graz.<br>
Meine Teilnahme an diesem Forschungsvorhaben ist freiwillig. Ich kann diese meine Einwilligung jederzeit an der Medizinischen Universität Graz ohne Angabe von Gründen widerrufen, ohne dass dadurch ein Nachteil für meine medizinische Betreuung entsteht.<br>
<br><div style="border: 1px solid;padding:10px;">
Ich wünsche über für mich persönlich oder meine direkten Nachkommen bedeutsame medizinische Forschungsergebnisse informiert zu werden. 
</div>
<br><br><br><br>
<div style="margin: auto;width: 100%;text-align: center;">
.....................................................................................<br>
(Datum und Unterschrift der /des Patienten/in)
</div>
<br>
<div style="margin: auto;width: 100%;text-align: center;">
Ich habe Herrn /Frau <b><%= organization.getExpandoBridge().getAttribute("firstname").toString() + " " + organization.getExpandoBridge().getAttribute("lastname").toString() %></b> vor der Unterzeichnung dieser Erklärung ausführlich beraten und bestätige, keinen Druck ausgeübt zu haben. 
</div>
<br><br><br>
<div style="margin: auto;width: 100%;text-align: center;">
.....................................................................................<br>
(Datum, Name und Unterschrift der/des verantwortlichen Ärztin/Arztes) 
</div>
<div style="margin: auto;width: 100%;text-align: center;">
Vielen Dank für ihre Teilnahme!
</div>
<%
}
%>