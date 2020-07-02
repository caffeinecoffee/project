$(function() {
	$('#reply').click(function() {
		document.parentForm.action = 'writeForm.sp';
		document.parentForm.submit();
	});

	$('#list1').click(function() {
		document.parentForm.action = 'boardList.sp';
		document.parentForm.submit();
	});
	
	$('#list2').click(function() {
		document.writePro.action = 'boardList.sp';
		document.writePro.submit();
	});
});