var table = $(document).ready(function () {
$('.data-table').DataTable({
    language: {
        url: "//cdn.datatables.net/plug-ins/1.13.6/i18n/pt-BR.json"
    },
    "order": [[0, "desc"]],
    ordering: false,
    lengthChange: true,      
    searching: true,      
    scrollY: "55vh",            
    scrollCollapse: true,    
    paging: true,     
    fixedHeader: {
        header: true, 
        footer: true 
    }, 
    pageLength: 10,            
    responsive: true 
    });
});

$(document).ready(function() {
    $('.select2').select2({
        placeholder: "Selecione o equipamento",
        allowClear: true,
        width: '100%'
    });
});