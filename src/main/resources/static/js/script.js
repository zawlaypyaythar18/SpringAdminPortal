$(document).ready(function() {
	$("#bookListTable").DataTable({
		"order": false,
		stateSave: true
	});

	$(function() {
		$('#selectAllBooks').on('change', function() {
			$('.checkBoxBook').prop('checked', $(this).prop('checked'));
		});
	});

	$(".delete-book").on('click', function() {
		var path = 'remove';
		var id = $(this).prop('id');

		bootbox.confirm({
			message: "Are you Sure you want to delete, it can't be undone.",
			buttons: {
				cancel: {
					label: 'Cancel',
					className: "btn btn-outline-danger btn-sm"
				},
				confirm: {
					label: 'Confirm',
					className: "btn btn-info btn-sm"
				}
			},
			callback: function(confirmed) {
				if (confirmed) {
					$.post(path, { 'id': id }, function(res) {
						location.reload();
					});
				}
			}
		});
	});
	
	
});