/* inicio de Codigo para el datatable */
$(document).ready(function () {
    $("#productos").DataTable({
        responsive: true,
        rowReorder: {
            selector: "td:nth-child(2)",
        },

        autoWidth: false,
        bDestroy: true,
        lengthMenu: [
            [5, 10, 25, 50, 100, -1],
            [5, 10, 25, 50, 100, "Todo"],
        ],
        language: {
            zeroRecords: "No se encontraron registros",
            info: "Mostrando página _PAGE_ de _PAGES_",
            infoEmpty: "No hay registros disponibles",
            infoFiltered: "(filtro de _MAX_ registros totales)",
            search: "Buscar:",
            paginate: {
                next: "Siguiente",
                previous: "Anterior",
            },
            lengthMenu: "Mostrar _MENU_ registros por página",
        },
        /* para exportar archivos lo básico sin estilo
        buttons: [
            'copy',
            'csv',
            'excel',
            'pdf',
            {
                extend: 'print',
                text: 'Print of Data',
                exportOptions:{
                    modifier: {
                        selected: null
                    }
                }
            }
        ],*/
        dom: '<"row"<"col-md-6"l><"col-md-6"f>>Brtip',
        buttons: [
            {
                extend: "excel",
                text: '<i class="fas fa-file-excel"></i> Excel',
                className: "rounded bg-success text-white",
                exportOptions: {
                    modifier: {
                        selected: null,
                    },
                },
            },
            {
                extend: "pdf",
                text: '<i class="fas fa-file-pdf"></i> PDF',
                className: "rounded bg-danger text-white",
                exportOptions: {
                    modifier: {
                        selected: null,
                    },
                },
            },
            {
                extend: "print",
                text: '<i class="fas fa-print"></i> Print',
                className: "rounded bg-secondary text-white",
                exportOptions: {
                    modifier: {
                        selected: null,
                    },
                },
            },
        ],
        select: true,
    });
});
/* Fin del codigo para datatable */