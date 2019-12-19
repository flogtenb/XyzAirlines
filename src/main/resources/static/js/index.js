// Javascript bestand airplanepagina @Frank
//

// AJAX gebruiken om backend data in te laden naar jquery
$(document).ready(function(){
getData();
    });

function getData() {

    $(document).ready(function(){

	$.ajax({
		url : "http://localhost:8080/api/airplanes",
		type : "get",
		success: function(data){

			var airplaneTableContent = "";
			console.log("airplaneObject");

				$.each(data, function(index, current) {
                    console.log("each function is initiated");

				 	var columnRow = "<tr><td>" + current.id + "</td><td>" + current.airplaneNr + "</td><td>"
				 	+ current.airplaneType + "</td><td>" +  current.currentLocation + "</td><td>" 
                    + current.destinationLocation + "</td><td>"+ current.fuelInTank + "</td><td>" +
                    "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteAirplaneModal' id='current.id' onclick='deleteAirplane(" + current.id + ")'> Delete </button>" + "</td><td>"
                    + "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editAirplaneModal' id='current.id' onclick='editAirplane(" + current.id + ")'> Edit </button>" + "</td></tr>";

                    // Prefilling values in the edit modal
                    $("#airplaneNrEdit").val(current.airplaneNr);
                    $("#airplaneTypeEdit").val(current.airplaneType);

				 	airplaneTableContent += columnRow;

				});
                console.log(airplaneTableContent);

                $("#airplaneTable").empty();
				$("#airplaneTable").append(airplaneTableContent);

				}
		});
    });
}


function editAirplane(id){
    console.log("Trying to edit data");
    console.log("Dit is ID: " + id);

    $("#editAirplane").click(function(){
        console.log("clicked Edit");
        var inputID = id;
        var inputAirplaneNr = $("#airplaneNrEdit").val();
        var inputAirplaneType = $("#airplaneTypeEdit").val();
        var inputCurrentLocation = $("#currentLocationEdit").val();
        var inputDestinationLocation = $("#destinationLocationEdit").val();
        var inputFuelInTank = $("#fuelInTankEdit").val();

        console.log(inputID);

        var newAirplaneUpdateObject = {
                    id : inputID,
                    airplaneNr : inputAirplaneNr,
                    airplaneType : inputAirplaneType,
                    currentLocation : inputCurrentLocation,
                    destinationLocation : inputDestinationLocation,
                    fuelInTank : inputFuelInTank
                    };
        console.log(newAirplaneUpdateObject);
        var newAirplaneUpdate = JSON.stringify(newAirplaneUpdateObject);
        console.log(newAirplaneUpdate);

        $.ajax({
            url : "http://localhost:8080/api/airplanes/"+id,
            type : "put",
            data : newAirplaneUpdate,
            contentType : "application/json",
            success : function(data){
                console.log("successful put")
                getData();
            }
        });
    });
};


//
//function editAirplane(id){
//
//   var airplanenr = "";
//   var airplanetype = "";
//   var currentlocation ="";
//   var destinationlocation ="";
//   var fuelintank ="";
//
//   $("#airplaneTable").each(function(){
//        var airplanenr = '#airplanenr' + id;
//        airplanenr = $(airplanenr).html();
//        console.log(airplanenr);
//
//        var airplanetype = '#airplanetype' + id;
//        airplanetype = $(airplanetype).html();
//        console.log(airplanetype);
//
//        var currentlocation = '#currentlocation' + id;
//        currentlocation = $(currentlocation).html();
//        console.log(currentlocation);
//
//        var destinationlocation = '#destinationlocation' + id;
//        destinationlocation = $(destinationlocation).html();
//        console.log(destinationlocation);
//
//        var fuelintank = '#fuelintank' + id;
//        fuelintank =$(fuelintank).html();
//        console.log(fuelintank);
//
//   });
//
//    console.log("Change placeholder")
////    $("#firstnameEdit").attr('placeholder', 'some text');
//    $("#airplaneNrEdit").val(airplanenr);
//    $("#airplaneTypeEdit").val(airplanetype);
//    $("#currentLocationEdit").val(currentlocation);
//    $("#destinationLocationEdit").val(destinationlocation);
//    $("#fuelInTankEdit").val(fuelintank);
//
//    //$('#editAirplaneModal').modal('show');
//
//    $("#finalEdit").click(function(){
//    console.log("clicked Edit");
//
//    var inputID = id;
//    var inputAirplaneNr = $("#airplaneNrEdit").val();
//    var inputAirplaneType = $("#airplaneTypeEdit").val();
//    var inputCurrentLocation = $("#currentLocationEdit").val();
//    var inputDestinationLocation = $("#destinationLocationEdit").val();
//    var inputFuelInTank = $("#fuelInTankEdit").val();
//
//    console.log(inputID);
//
//      if(inputAirplaneNr == "" ||inputAirplaneType == "" || inputCurrentLocation == "" || inputDestinationLocation == "") {
//                $("#errorMessage").val("Fill in Airplane.");
//                return;
//            }
//
//
//    var newAirplaneUpdateObject = {
//                id : inputID,
//                airplaneNr : inputAirplaneNr,
//                airplaneType : inputAirplaneType,
//                currentLocation : inputCurrentLocation,
//                destinationLocation : inputDestinationLocation,
//                fuelInTank : inputFuelInTank
//                };
//    console.log(newAirplaneUpdateObject);
//    var newAirplaneUpdate = JSON.stringify(newAirplaneUpdateObject);
//    console.log(newAirplaneUpdate);
//
//
//    $.ajax({
//        url : "http://localhost:8080/api/airplanes/"+id,
//        type : "put",
//        data : newAirplaneUpdate,
//        contentType : "application/json",
//        success : function(data){
//            console.log("successful put")
//
//            getData();
//            location.reload();
//        }
//
//    });
//    });
//};
//
// einde van edit airplane




function postData(){
	// The postData function is triggered by the add new airplane button. This function has to post the filled in data into the table.

    // First we need to put the values of the input fields into variables
    var inputAirplaneNr = $("#airplaneNr").val();
    var inputAirplaneType = $("#airplaneType").val();
    var inputCurrentLocation = $("#currentLocation").val();
    var inputDestinationLocation = $("#destinationLocation").val();
    var inputFuelInTank = $("#fuelInTank").val();


    // Here we make a new object
    var newAirplaneObject = {
    airplaneNr : inputAirplaneNr,
    airplaneType : inputAirplaneType,
    currentLocation : inputCurrentLocation,
    destinationLocation : inputDestinationLocation,
    fuelInTank : inputFuelInTank
    };

    // Make the object readable for the backend by parsing it to JSON
    var newAirplane = JSON.stringify(newAirplaneObject);
    console.log(newAirplane);

    // Save the actual data to the repository
    $.ajax({
        url : "http://localhost:8080/api/airplanesave",
        type : "post",
        data : newAirplane,
        contentType : "application/json",
        success: function(data){
            console.log("Success post!");
            getData();
        }
    });
};


function deleteAirplane(id){

$("#deleteThisAirplane").html("Are you sure you want to delete airplane #" + id + "?");

    $("#finalDelete").click(function(){

                console.log("function modalDeleteAirplane is being used")

                $.ajax({
                        url : "http://localhost:8080/api/airplanes/"+id,
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Deletion is initiated");

                            $("#airplaneTable").html("");

                            getData();
                            }
                });
            });
}


function searchAirplane(){
    console.log("Trying to search for airplanes");

    var inputSearchTerm = $("#searchAirplane").val();

        console.log("http://localhost:8080/api/airplanes/search/"+inputSearchTerm);

    $.ajax({
        url : "http://localhost:8080/api/airplanes/search/"+inputSearchTerm,
        type : "get",
        contentType : "application/json",
		success : function(data){
		console.log(data)
            var airplaneSearch = "";
            console.log(airplaneSearch);
            $.each(data, function(index, current){

				var columnRow = "<tr><td>" + current.id + "</td><td>" + current.airplaneNr + "</td><td>"
					+ current.airplaneType + "</td><td>" + current.currentLocation + "</td><td>" 
					+ current.destinationLocation + "</td><td>" + current.fuelInTank + "</td><td>" +
					"<button type='button' class='btn btn-danger' onclick='modalDeleteAirplane(" + current.id + ")'> Delete </button>" + "</td><td>"
					+ "<button type='button' class='btn btn-info' onclick='modalEditAirplane(" + current.id + ")'> Edit </button>" + "</td></tr>";
					airplaneSearch +=columnRow;
					console.log("airplaneSearch: " + airplaneSearch);
				});
				$(".airplaneTable").html(airplaneSearch);
				$("#searchAirplane").val("");
        }
    });
}
