// Update this variable to point to your domain.
var apigatewayendpoint = 'http://localhost:8080/manual/search';
var loadingdiv = $('#loading');
var noresults = $('#noresults');
var resultdiv = $('#results');
var searchbox = $('input#search');
var timer = 0;

// Executes the search function 250 milliseconds after user stops typing
searchbox.keyup(function () {
  clearTimeout(timer);
  timer = setTimeout(search, 250);
});

async function search() {
  // Clear results before searching
  noresults.hide();
  resultdiv.empty();
  loadingdiv.show();
  // Get the query from the user
  let query = searchbox.val();
  // Only run a query if the string contains at least three characters
  if (query.length > 2) {
    // Make the HTTP request with the query as a parameter and wait for the JSON results
    let response = await $.get(apigatewayendpoint, { id: query, size: 25 }, 'json');
    // Get the part of the JSON response that we care about
    let results = response['searchHits'];
    if (results.length > 0) {
      loadingdiv.hide();
      // Iterate through the results and write them to HTML
      resultdiv.append('<p>Found ' + results.length + ' results.</p>');
      for (var item in results) {
        //let url = 'https://www.imdb.com/title/' + results[item]._id;
        //let image = results[item]._source.fields.image_url;
        //let title = results[item]._source.fields.title;
        //let plot = results[item]._source.fields.plot;
        //let year = Json.parse(results[item]);
		// let lyrics = year.content;
		let lyrics = results[item].content.lyrics;
        let track_name = results[item].content.track_name_si;
        let artist = results[item].content.artist_name_si;
        // let lyrics = results[item].content.lyrics;

		
        // Construct the full HTML string that we want to append to the div
        resultdiv.append('<div class="result">' + '<div><p>Track: ' + track_name+'<br></br>Artist: '+ artist+'<br></br>'+ lyrics + '</p></div></div>');
      }
    } else {
      noresults.show();
    }
  }
  loadingdiv.hide();
}

// Tiny function to catch images that fail to load and replace them
function imageError(image) {
  image.src = 'images/no-image.png';
}
