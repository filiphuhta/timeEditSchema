
 
var SchemaLista = { listaSchema: [] };
      
 function loadSchema(){
     
 var x = document.getElementById("test").rows.length;
console.log("antal rader inann: "+ x);
   if(x === 0){ 
 var Parent = document.getElementById("test");
 
   while(Parent.hasChildNodes())
{
   Parent.removeChild(Parent.firstChild);
}

         
     
       $.getJSON(document.getElementById("kurstillfalle").value, 
        function(data) {
         
         
        
            
            console.log("Antal rader: "+ x);
        for(let i = 0; i < data.reservations.length; i++){
              
        SchemaLista.listaSchema.push({ 
                      
                      "id"          : data.reservations[i].id,
                      "kurs"       : data.reservations[i].columns[5],
                      "typ"         :data.reservations[i].columns[3],
                      "datum"       : data.reservations[i].startdate,
                      "starttid"    : data.reservations[i].starttime,
                      "sluttid"     : data.reservations[i].endtime,
                      "beskrivning" : ""
                  });
         
            }
    for(let i = 0; i < SchemaLista.listaSchema.length ; i++){
      
    var text = `<tr><td class="id" >${SchemaLista.listaSchema[i].id}</td>
                    <td class="kurs">${SchemaLista.listaSchema[i].typ}</td>
                    <td class="typ">${SchemaLista.listaSchema[i].datum}</td>
                    <td class="datum">${SchemaLista.listaSchema[i].starttid}</td>
                    <td class="sluttid">${SchemaLista.listaSchema[i].sluttid}</td>
                    <td class="beskrivning">${SchemaLista.listaSchema[i].beskrivning}</td></tr>`;
                
                
        $(".test").append(text); 
            
            }
             
       
    console.log(SchemaLista);
    findSchema(SchemaLista);
                });
        }
          
            else{
                console.log("stop");
            }
         
        };
   
  
   function findSchema(SchemaLista){
   
   $(".test").on('click','tr',function(e){
    e.preventDefault();
    //var id = $(this).text();
  var id = $(this).children('.id').text();
    for(let i = 0; i < SchemaLista.listaSchema.length ; i++){
      //  var id = $(this).children('.id').text();
        if(id === SchemaLista.listaSchema[i].id){
            
            var id = SchemaLista.listaSchema[i].id;
            var datum = SchemaLista.listaSchema[i].datum;
            var start = SchemaLista.listaSchema[i].starttid;
            var stop = SchemaLista.listaSchema[i].sluttid;
            var beskrivning = SchemaLista.listaSchema[i].beskrivning;
            var typ = SchemaLista.listaSchema[i].typ;
            
                         //   $(".idet").append(id); 
                         document.getElementById("idet").innerHTML = id;
                         document.getElementById("datum").innerHTML = datum;
                         document.getElementById("typ").innerHTML = typ;
                         document.getElementById("start").innerHTML = start;
                         document.getElementById("stop").innerHTML = stop;
                         document.getElementById("beskrivning").innerHTML = beskrivning;
                  
        }
        
    }
     }); 
     
    
       $( ".saveDesc" ).click(function() {
  
       var str = $("#beskrivning").val();
       console.log(str);
       var labelText = $("#idet").text();
       console.log(labelText);
    
       for(let i = 0; i < SchemaLista.listaSchema.length ; i++){
       console.log("This is the id: "+labelText);
       if(labelText === SchemaLista.listaSchema[i].id){
            
            SchemaLista.listaSchema[i].datum;
            SchemaLista.listaSchema[i].datum;
            var besk = SchemaLista.listaSchema[i].beskrivning = str;
            

            
                       
        }
        
    
    
        
}

getSchema();
     });
     
  
   
   
   };
   
   function getSchema(){
       $(".test tr").remove();
       
       for(let i = 0; i < SchemaLista.listaSchema.length ; i++){
      
    var text = `<tr><td class ="id">${SchemaLista.listaSchema[i].id}</td>
                    <td>${SchemaLista.listaSchema[i].typ}</td>
                    <td>${SchemaLista.listaSchema[i].datum}</td>
                    <td>${SchemaLista.listaSchema[i].starttid}</td>
                    <td>${SchemaLista.listaSchema[i].sluttid}</td>
                    <td>${SchemaLista.listaSchema[i].beskrivning}</td></tr>`;
                
                
        $(".test").append(text); 
            
            }
       
    
    
   }
 
    function myFunction() {
            //This performs a POST-Request.
            //Use "$.get();" in order to perform a GET-Request (you have to take a look in the rest-API-documentation, if you're unsure what you need)
            //The Browser downloads the webpage from the given url, and returns the data.
            $.get( "http://localhost:8080/schemaProjekt_3/resources/javaee8/", function( data ) {
                 //As soon as the browser finished downloading, this function is called.
                 $('#demo').html(data);
            });
        }
        
       function addSchema(){
    console.log("hejhej test");
    //här skriver den över JSON och sparar den till en sträng
    var myJson = JSON.stringify(SchemaLista.listaSchema);
    
    $.ajax
    ({
    type: "POST",
    url: "http://localhost:8080/schemaProjekt_3/resources/javaee8/canvas",
    data:  myJson, //här skickas strängen 
    contentType: "application/json",
    dataType: "json"
     
    });
    
    

}