$(document).ready(function() {
	centralizeTexts();
});

function centralizeTexts() {
	centerText($('.response-content-left'), $('.response-left'));
	centerText($('.rotate-content-left'), $('.question-left'));
	centerText($('.rotate-content-right'), $('.question-right'));
	centerText($('.response-content-right'), $('.response-right'));
}

function centerText(oFirstHeight, oSecondHeight) {
	if(oFirstHeight.attr('class').indexOf('left') > 0) {
		oSecondHeight.css('top', ((oFirstHeight.height() / 2) + oSecondHeight.width()));
	} else {
		oSecondHeight.css('top', oFirstHeight.height() / 2);
	}
}

function goToHome() {
	location.href = "index.html";
}

function goToQuiz() {
	location.href = "quiz.html";

}