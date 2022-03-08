const fetchAPIWeather = () => {
  $(function () {
    $.getJSON("http://ip.jsontest.com/", function (data) {
      fetch(
        `http://api.weatherapi.com/v1/current.json?key=bc2899196429470f9ed34549220803&q=${data.ip}&aqi=no`
      )
        .then((response) => response.json())
        .then((dataa) => show(dataa));
    });
  });
};

fetchAPIWeather();

function show(data) {
  let tab = `
  <div class="location">Weather in <br>${data.location.name}, ${data.location.region} <br> last updated : ${data.current.last_updated}</div>
  <div class="weatherStatus">
    <div class="weatherIcon"><img src="${data.current.condition.icon}" width="35"/></div>
    <div class="weatherIconTitle">${data.current.temp_c}\&#8451; ${data.current.condition.text}</div>
  </div>`;

  // Setting innerHTML as tab variable
  document.getElementById("weather").innerHTML = tab;
}
