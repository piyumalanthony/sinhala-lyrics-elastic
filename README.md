# sinhala-lyrics-elastic
This repository includes the API and corpus used to develop Sinhala songs lyrics search engine. The API is developed based on Java Spring framework. The corpus was extracted using musixmatch developers API on https://developer.musixmatch.com/.
## Directories
o	Src – java API for search engine

o	Scarper – the scrapy and selenium implementation for scraper

o	Lyrics corpus – processed and raw data extracted from web

o	Frontend – simple frontend implementation for search engine

## Quick start
1. Clone the repository.

2. Install elastic search in your machine or point to the ipaddress of the remote server by editing host configurations of application.properties file. (https://www.elastic.co/guide/en/elasticsearch/reference/current/install-elasticsearch.html) 

3. Build the project or extract jar from the project and execute the jar to run the application.

4. Open index.html file in the frontend directory to search lyrics.
## Song corpus

The following metadata were included in the corpus with lyrics.

•	track_id – unique identifier for the music track

•	sinhala_track_name  – Sinhala track name

•	singlish_track_name  – track name in Singlish

•	track_rating – user rating for the track

•	sinhala_album_name  – the album where the song was included

•	singlish_album_name  – the name of the album where the song was included

•	sinhala_artist_name  – name of the artist who belongs the song

•	singlish_artist_name – artist name in Singlish

•	artist_rating – rating of the artist

•	lyrics – song lyrics in Sinhala

## API endpoints

| API end point       | Type of request     | Parameter type   |   Example  |Description |
| :------------- | :----------: | -----------: |----------- | -----------: |
|  http://localhost:8080/manual/search | GET | Query parameter    | http://localhost:8080/manual/search?id= අම්මා | Retrive lyrics realted to user query|
|http://localhost:8080/rest/search/findAll' | GET |  ---  |http://localhost:8080/rest/search/findAll' | Retrive all the lyrics in the corpus |
|http://localhost:8080/manual/search/lyrics'|PUT|---   |http://localhost:8080/manual/search/lyrics'| Add lyrics to the elastic database|
