$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://localhost:9999/students/",
    success: function (contactArray) {
      $.each(contactArray, function (index, contact) {
        var selected = $("#stutable");
        var id = contact.id;
        var contactInfo = "<tr>";
        contactInfo += "<td id='test'>" + contact.id + "</td>";
        contactInfo += "<td>" + contact.name + "</td>";
        contactInfo += "<td>" + contact.age + "</td>";
        contactInfo += "<td>" + contact.mobile + "</td>";
        contactInfo += "<td>" + contact.address + "</td>";
        contactInfo +=
          "<td>" +
          '<button class="btn btn-primary" id="selectstu" value=' +
          id +
          ">Select</button>" +
          "</td>";
        contactInfo += "</tr>";
        selected.append(contactInfo);
      });
    },
    error: function () {
      alert("FAILURE!");
    },
  });
});

$(document).ready(function () {
  $("button#poststudent").click(function () {
    var student = {
      name: $("#name").val(),
      age: $("#age").val(),
      mobile: $("#mobile").val(),
      address: $("#address").val(),
    };

    $.ajax({
      url: "http://localhost:9999/students/",
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      success: function (data) {
        alert("Student Successfully Registered!");
        document.getElementById("myForm").reset();
      },
      data: JSON.stringify(student),
    });
  });
});

$(document).ready(function () {
  $("#deletestu").on("click", function () {
    //var id = $('#deletestudent').attr('value');
    var id = localStorage.getItem("selectedId");
    $.ajax({
      url: "http://localhost:9999/students/" + id,
      type: "DELETE",
      dataType: id,
      contentType: "application/json",
      success: function (data) {},
    });
    alert("Student Successfully Deleted!");
    history.back();
  });
});


//view all
$(document).ready(function () {
  $("#stutable").on("click", "#selectstu", function () {
    var id = this.value;
    localStorage.setItem("selectedId", id);
    location.href = "selected.html";
  });
});

//Search

$(document).ready(function () {
  $("#results").on("click", "#selectstu", function () {
    var id = $("#selectstu").attr("value");
    localStorage.setItem("selectedId", id);
    location.href = "selected.html";
  });
});

$(document).ready(function () {
  $("#loadstu").on("click", function () {
    var id = localStorage.getItem("selectedId");
    $.ajax({
      url: "http://localhost:9999/students/" + id,
      type: "GET",
      dataType: "json",
      contentType: "application/json",
      success: function (data) {
        alert("ID = " + id);
        var selected = $("div#selectedstudent");
        var stuid = data.id;
        var contactInfo = "<p>";

        contactInfo += '<label for="id">ID:</label>';
        contactInfo +=
          '<input type="text" id="id" name="id" value="' +
          data.id +
          '" readonly></input>';

        contactInfo += '<label for="name">Name:</label>';
        contactInfo +=
          '<input type="text" id="name" name="name" value="' +
          data.name +
          '"></input>';

        contactInfo += '<label for="age">Age:</label>';
        contactInfo +=
          '<input type="text" id="age" name="age" value="' +
          data.age +
          '"></input>';

        contactInfo += '<label for="mobile">Mobile:</label>';
        contactInfo +=
          '<input type="text" id="mobile" name="mobile" value="' +
          data.mobile +
          '"></input>';

        contactInfo += '<label for="address">Address:</label>';
        contactInfo +=
          '<input type="text" id="address" name="address" value="' +
          data.address +
          '"></input>';

        contactInfo += "</p><hr>";
        selected.append(contactInfo);
      },
      error: function () {
        alert("FAILURE!");
      },
    });
  });
});

$(document).ready(function () {
  $("button#savestu").click(function () {
    var id = localStorage.getItem("selectedId");
    var student = {
      id: $("#id").val(),
      name: $("#name").val(),
      age: $("#age").val(),
      mobile: $("#mobile").val(),
      address: $("#address").val(),
    };

    $.ajax({
      url: "http://localhost:9999/students/",
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      success: function (data) {
        alert("Student Successfully Updated!");
      },
      data: JSON.stringify(student),
    });
  });
});

$(document).ready(function () {
  $("button#searchstu").click(function () {
    var name = $("#name").val();
    $.ajax({
      url: "http://localhost:9999/students/name/" + name,
      type: "GET",
      dataType: "json",
      contentType: "application/json",
      success: function (contactArray) {
        var contactsDiv = $("div#results");
        //$("div#allContacts").html(result);
        //alert("result:" + contactArray);
        var contactInfo = "<table class='table'>";
        contactInfo += "<thead>";
        contactInfo += "<tr>";
        contactInfo += "<th scope='col'>ID</th>";
        contactInfo += "<th scope='col'>Name</th>";
        contactInfo += "<th scope='col'>Age</th>";
        contactInfo += "<th scope='col'>Mobile</th>";
        contactInfo += "<th scope='col'>Address</th>";
        contactInfo += "<th scope='col'></th>";
        contactInfo += "</tr>";
        contactInfo += "</thead>";
        contactInfo += "<tbody>";

        $.each(contactArray, function (index, contact) {
          var stuid = contact.id;

          contactInfo += "<tr>";
          contactInfo += "<td>" + contact.id + "</td>";
          contactInfo += "<td>" + contact.name + "</td>";
          contactInfo += "<td>" + contact.age + "</td>";
          contactInfo += "<td>" + contact.mobile + "</td>";
          contactInfo += "<td>" + contact.address + "</td>";
          contactInfo +=
            "<td>" +
            '<button class="btn btn-primary" id="selectstu" value="' +
            stuid +
            '">Select</button>' +
            "</td>";
          contactInfo += "</tr>";

          contactsDiv.append(contactInfo);
        });

        contactInfo += "</tbody>";
        contactInfo += "</table>";
      },
      error: function () {
        alert("FAILURE!");
      },
    });
  });
});
