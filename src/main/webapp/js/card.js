$(document).ready(function(){

/*FILTER/CARDS PAGES JS************************************/
	var filterBtns = $('.filter-btn');
	var cards = $('.card');
	filterBtns.click(function(event){
		/*Takes care of highlighting current filter*/
		event.preventDefault();
		$('.selected').removeClass('selected');
		$(this).addClass('selected');

		/*Takes care of showing correct cards*/
		var currentFilter = $(this).attr('data-filter');
		if(currentFilter === 'all'){
			jQuery.each(cards, function(i, v){
				$(this).show();
			});
		}
		else{
			jQuery.each(cards, function(i, v){
				/*If statement checks if any of the filters are in the currentFilter*/
				if(v.getAttribute('data-filter').indexOf(currentFilter) >= 0){
					$(this).show();
				}
				else{
					$(this).hide();
				}
			});
		}
	});


	
	/*Takes care of cutting extra chars from cards*/
	var bodyText = $('.card-body');
	bodyText.each (function () {
		$(this).text( $(this).attr('data-short-text') );
	});


	/*Takes care of expanding card when more info is clicked*/
	var moreLinks = $('.more-link');

	moreLinks.click(function(event){
		var cardClicked = $(this).parents('.card');
		var textContainer = cardClicked.find('.card-text-container');
		var cardClickText = cardClicked.find('.card-body');
		var locationInfo = cardClicked.find('p.card-location');

		/*Checks to see if card is already open*/
		if($(this).html() === 'Back'){
			if($(window).width() >= 768){
				$("html, body").animate({ scrollTop: 400 }, "slow");
			}
			cardClickText.text(cardClickText.attr('data-short-text'));
			locationInfo.fadeOut('easeOutExpo');

			cardClicked.css({
				'width': '300px',
				'height' : '500px',
				'margin' : '10px',
				'display': 'inline-block'
			});
			cardClicked.find('.card-img-container').css({
				'height' : '200px'
			});
			$(this).html('More Info');
			textContainer.removeClass('expanded');
		}

		/*If it isnt open, then depending on device transform width and height or just height*/
		else{
			$(this).html('Back');
			
			cardClickText.text(cardClickText.attr('data-orig-text'));
			locationInfo.fadeIn('easeInQuint');
			var pos = cardClicked.position();

			/*If desktop*/
			if($( window ).width() >= 768){
				cardClicked.css({
					'display': 'block',
					'margin' : '0 auto',
					'width': '750px',
					'height' : '750px'
				});

				cardClicked.find('.card-img-container').css({
					'height' : '350px'
				});

				
			}
			/*If mobile*/
			else{
				cardClicked.css('height', '750px');
			}
			textContainer.addClass('expanded');
			// $("html, body").animate({ scrollTop: pos.top + 900 }, "slow");
		}
		
	});
/**/

});