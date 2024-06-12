$(document).ready(function () {
    $('.social-icons .fav').on('click', function (event) {
		event.preventDefault();
		var data = {
			Location: $(event.currentTarget).attr('id'),
			PartitionKey: 'PartitionKey',
			RowKey: Date.parse(new Date()).toString(),
			Name: 'Dummy User'
		}

		$.ajax('【URL】',
			{
				method: 'POST',
				data: JSON.stringify(data)
			})
			.done(function () {
				alert('投票ありがとうございます');
            })
            .fail(function () {
                console.log('Error発生');
            });
	});
});