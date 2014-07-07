/**
 * Ajout dynamique de champs input text dans le formulaire d'insertion des catégories
 */

$(document).ready(function() {

var nbMaxChamps       = 6; //maximum input boxes allowed
var InputsWrapper   = $("#inputProprietes"); //Input boxes wrapper ID
var AddButton       = $("#ajoutProp"); //Add button ID

var x = InputsWrapper.length; //initlal text box count
var compteurChamp =1; //to keep track of text box added
$(AddButton).click(function (e)  //on add input button click
{
        if(x <= nbMaxChamps) //max input box allowed
        {
        	//compteurChamp++; //text box added increment
            //add input box
            $(InputsWrapper).append(
            		'<div style="margin-left: 0px">Propri&eacute;t&eacute; </span>' + compteurChamp++ + 
            		' <input type="text" name="prop'+compteurChamp +'"  value="" required="required"/><a href="#" class="removeclass">&times; Supprimer</a></div>');
            x++; //text box increment
            $('input[name="totalChamps"]').val(compteurChamp);
        }
return false;
});


$("body").on("click",".removeclass", function(e){ //user click on remove text
        if( x > 1 ) {
                $(this).parent('div').remove(); //remove text box
                compteurChamp--; //decrement textbox
                x--;
        }
return false;
});

});