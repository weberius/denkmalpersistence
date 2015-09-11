#denkmalpersistence

Ziel dieses Services ist es auf Basis von in einer MongoDB persistierten Informationen, alle Informationen zur Verfügung zu stellen, die notwendig sind, um die Webapplikation denkmalinkoeln mit Informationen zu versorgen. Hierfür werden die Informationen aus den offenen Daten der Stadt Köln und vom OSM-Geocoder zusammengeführt. 

Grundlage hierfür sind die Services [denkmalgeocoding](https://github.com/weberius/denkmalgeocoding) und [denkmallistekoeln](https://github.com/weberius/denkmallistekoeln).

## Zugriffspunkte

Dieser Service ist noch in Entwicklung. Nicht alle Services sind implementiert. Nicht implementierte Services sind durch TODO gekennzeichnet. 

###/denkmalpersistence/service/nogeo

Gibt alle nicht geocodierten Denkmäler in Form eines JSON zurück. 

###/denkmalpersistence/service/nogeo/Denkmalliste.csv (TODO)

Gibt alle nicht geocodierten Denkmäler in Form eines csv zurück. Die Formatierung orientiert sich an [Denkmalliste Koeln 2015](http://www.offenedaten-koeln.de/dataset/4bab19f6-726b-4cc6-8284-f81ec45c61b2/resource/4bab19f6-726b-4cc6-8284-f81ec45c61b2) 

###/denkmalpersistence/service/nogeo/datatables (TODO)

Gibt alle nicht geocodierten Denkmäler in Form einer für [https://datatables.net/]Datatables(https://datatables.net/) passenden Struktur zurück.

###/denkmalpersistence/service/geo

Gibt alle geocodierten Denkmäler in Form eines GeoJson zurück. 

###/denkmalpersistence/service/geo/Denkmalliste.csv (TODO)

Gibt alle nicht geocodierten Denkmäler in Form eines csv zurück. Die Formatierung orientiert sich an [Denkmalliste Koeln 2015](http://www.offenedaten-koeln.de/dataset/4bab19f6-726b-4cc6-8284-f81ec45c61b2/resource/4bab19f6-726b-4cc6-8284-f81ec45c61b2) 

###/denkmalpersistence/service/geo/datatables (TODO)

Gibt alle nicht geocodierten Denkmäler in Form einer für [Datatables](https://datatables.net/) passenden Struktur zurück.

###/denkmalpersistence/service/load

Fragt die Offenen Daten der Stadt Köln ab und führt sie mit den Ergebnissen des Geocodierens zusammen. Hierdurch wird die Datenbank initialisiert. Voraussetzung für diesen Service ist eine erreichbare MongoDB, sowie die Services [denkmalgeocoding](https://github.com/weberius/denkmalgeocoding) und [denkmallistekoeln](https://github.com/weberius/denkmallistekoeln)

###/denkmalpersistence/service/Denkmalliste.csv (TODO)

Gibt alle abgespeicherten Denkmäler in Form einer csv-Datei zurück. Ggf. vorhandene Georeferenzierungen werden mit ausgegeben. Die Formatierung orientiert sich an [Denkmalliste Koeln 2015](http://www.offenedaten-koeln.de/dataset/4bab19f6-726b-4cc6-8284-f81ec45c61b2/resource/4bab19f6-726b-4cc6-8284-f81ec45c61b2) 
 