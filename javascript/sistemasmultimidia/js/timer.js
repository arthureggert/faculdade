function Timer(callback, delay) {
	var id, started, remaining = delay, running, secInterval = 0;

	this.start = function() {
		running = true;
		started = delay;
		callback();
		remaining = started;
		id = setInterval(this.timeOut, 1000);
	};

	this.pause = function() {
		running = false;
		clearInterval(id);
		remaining = started;
	};

	this.getTimeLeft = function() {
		if (running) {
			this.pause();
			this.start();
		}
		return remaining;
	};

	this.getStateRunning = function() {
		return running;
	};

	this.timeOut = function() {
		var time = toHHMMSS(remaining);
		$(".timer-left").html(time);
		$(".timer-right").html(time);
		remaining -= 1000;
		if(remaining  < 0) {
			callback();
			remaining = started;
		}

		function toHHMMSS (value) {
			//console.log(vak)
			value  /= 1000;
			var sec_num = parseInt(value, 10); // don't forget the second param
			var hours   = Math.floor(sec_num / 3600);
			var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
			var seconds = sec_num - (hours * 3600) - (minutes * 60);

			if (hours   < 10) {hours   = "0"+hours;}
			if (minutes < 10) {minutes = "0"+minutes;}
			if (seconds < 10) {seconds = "0"+seconds;}
			var time    = minutes+':'+seconds;
			return time;
		}
	};
	this.start();
}