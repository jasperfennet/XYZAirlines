function getAllPlanes() {

    $.ajax({
        url: "http://localhost:8080/api/plane/all",
        type: "get",
        success: function(plane) {
            // On successful get, reload the datatable with new data.

            $('#PlaneTable').DataTable().clear();
            $('#PlaneTable').DataTable().rows.add(plane );
            $('#PlaneTable').DataTable().columns.adjust().draw();
        }
    });
}

function deletePlane(planeID) {

    $.ajax({
        url: "http://localhost:8080/api/plane/delete/" + planeID,
        type: "DELETE",
        success: function(result) {
            // On successful post, reload data to get the added one as well.

            getAllPlanes();
        }
    });
}

function postPlane() {


    // Get values from html.
    var fuel = $("#inputFuel").val();

    // Create JS object with data.
    var newPlane = {
        fuel: fuel
    };


    // Convert JS object to JSON.
    var validJsonTable = JSON.stringify(newPlane);


    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/plane/post",
        type: "post",
        data: validJsonTable,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.

            getAllPlanes();
        }
    });
}

$(document).ready(function() {

    // Modal submit.
    $("#newPlaneForm").on('submit', function(e) {


        // Post the data from the modal.
        postPlane();

        // Reset modal to hide and no values.
        $('#newPlaneModal').modal('hide');
        $("#inputPlaneNR").val("");
    });

    $('#PlaneTable').DataTable({
        columns: [
            { data: "planeId" },
            { data: "fuel" },
            {
                data: function() {
                    return '<button onclick="deletePlane(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },





        ]
    });
    getAllPlanes();
})
