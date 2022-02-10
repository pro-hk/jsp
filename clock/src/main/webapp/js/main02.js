$.ajax({
	url: "ClockJsonList.do",
	// dataType: "json",  // 넘어오는 데이터를 json으로 처리
	success: function(data) {
		console.log(data);
		const clockList = data.clockList;
		//console.log(clockList);
		let output = "";
		$.each(clockList, function(idx, item) {
			output += `
			<div class="section" id="" style="background-image:url('upload_clock/${item.clockRealImg}')">
	            <div class="info">
	                <p class="category" data-splitting>${item.category}</p>
	                <p class="title" data-splitting>${item.title}</p>
	                <p class="depth" data-splitting>${item.depth} MM</p>
	                <p class="price" data-splitting>CHF ${item.price}</p>
	            </div>
	        </div>`
		});
		$("#main").html(output);
		const fp = new fullpage("#main", {
			scrollBar: true,
			onLeave: function(original, destination, index) {
				//console.log(destination);
				moveChar(`.section:nth-child(${destination.index + 1}) .char`);
			}
		});
		Splitting();
		moveChar(`.section:nth-child(1) .char`);
		function moveChar(char) {
			gsap.from(char, {
				y: -200,
				opacity: 0,
				ease: "bounce",
				duration: 1.5,
				delay: 0.5,
				stagger: {
					amount: 1,
					from: "random"
				}
			});
		}
	}
})



