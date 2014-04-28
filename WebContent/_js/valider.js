function mutiselectCode() {
    $('#example22').multiselect({
        includeSelectAllOption: true,
        selectAllValue: 'multiselect-all',
        includeSelectAllDivider: true,
        buttonClass: 'btn',
        buttonWidth: 'auto',
        buttonText: function(options) {
            if (options.length == 0) {
                return 'Séléctionner une catégorie <b class="caret"></b>';
            }
            else if (options.length > 6) {
                return options.length + ' selectionnés <b class="caret"></b>';
            }
            else {
                var selected = '';

                options.each(function() {
                    selected += $(this).text() + ', ';

                });
                return selected.substr(0, selected.length - 2) + ' <b class="caret"></b>';
            }
        },
        onChange: function(element, checked) {
            if (checked == true) {
                // action taken here if true
            }
            else if (checked == false) {
                if (confirm("Souhaitez-vous pour désélectionner l'élément?")) {
                    // action taken here
                }
                else {
                    $("#example22").multiselect('select', element.val());
                }
            }
        }
    });
}

/*
 * D�sactive le bouton de recherche s'il n'y a aucune saisie 
 
$("#searchForm").submit( function(){
	
	if ($("#query").val() == '')
	{
		$("#searchForm input[type=submit]").attr("disabled");
	}
	
});
*/
