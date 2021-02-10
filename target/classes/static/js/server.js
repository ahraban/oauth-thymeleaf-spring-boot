function collectData(){
    let data = {};
    let inputVal = null;

    inputVal = $('#add-server-name');
    if(inputVal.val() != null || inputVal !== undefined){
        data['name'] = inputVal.val();
    }

    inputVal = $('#add-server-hostname');
    if(inputVal.val() != null || inputVal !== undefined){
        data['hostName'] = inputVal.val();
    }

    inputVal = $('#add-server-ipaddress');
    if(inputVal.val() != null || inputVal !== undefined){
        data['ipAddress'] = inputVal.val();
    }

    inputVal = $('#add-server-webURL');
    if(inputVal.val() != null || inputVal !== undefined){
        data['webURL'] = inputVal.val();
    }
    return data;
}
/*
function getAll(){
    $.get('/api/getAll', function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
}

function addServer(){
    let data = collectData();
    $.post('/api/addserver',
        data,
        function (data, status, xhr){
        console.log("Data: " + data + "\n Status: " + status)
        })
}*/

function addServer2(){
    console.log(' ----- LOG ----- ')
    let url ='http://' +  window.location.host + '/api/addserver';

    let data = collectData();

    $.ajax({
        "url": url,
        "data": JSON.stringify(data),
        "contentType": 'application/json; charset=utf-8',
        "cache": false,
        "type": "POST",
        "success": function (data, textStatus, xhr) {
            //console.log(" ---  xhr.status: "  + xhr.status )
            //console.log(" ---  textStatus: "  + textStatus )
            //console.log(" ---  data: "  + data )
        }

    })
/*        .error(function () {
        alert("Rest API error")
    })*/

    //console.log(" ---  post end: "  + data )
}

function addRow() {
    //add row
    let table = document.getElementById('table-server')
    let row = table.insertRow(1);

    let cellName = row.insertCell(0);
    //cellName.setAttribute('id', 'server-name-' + newServerId);
    cellName.innerHTML = $('#add-server-name').val();

    let cellHostname = row.insertCell(1);
    cellHostname.innerHTML = $('#add-server-hostname').val();

    let cellIpaddress = row.insertCell(2);
    cellIpaddress.innerHTML = $('#add-server-ipaddress').val();

    let cellWebURL = row.insertCell(3);
    cellWebURL.innerHTML = $('#add-server-webURL').val();
}