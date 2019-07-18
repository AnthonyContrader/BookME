var click = 0;

function arrow(){
   $('.burgx').css('transform', 'rotate(-45deg) translate(-2px,-0px)');
    $('.burgx').css('width', '14px');
    $('.burgx2').css('width', '20px');
    $('.burgx3').css('width', '15px');
    $('.burgx3').css('transform', 'rotate(45deg) translate(-2px, 1px)');
}

function burger(){
    $('.burgx').css('transform', 'rotate(0deg) translate(0px,0px)');
    $('.burgx').css('width', '20px');
    $('.burgx2').css('width', '20px');
    $('.burgx3').css('width', '20px');
    $('.burgx3').css('transform', 'rotate(0deg) translate(0px, 0px)');
}


function banner() {
  $("#banner").css("background", "#E5E5E7");
  click++;
  arrow();
  $('.icon').attr("src", "https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/ic_search_blk_24dp_r1.png");
  $('#inbox').css("color", "#555").text("Indietro");

}

function showCategorie() {
  click++;
  if (click == 1) {
   arrow();
    $('#notes').css("background", "white");
    $('#postponed').css("background", "white");
    $('.containermsg').css("border-radius", "50%");
    
    $('#menu').css("display","block").css("animation","slide-in 0.2s linear").css("animation-fill-mode","forwards");
    
  } else if (click >= 1) {

    $('#notes').css("background", "#7baaf7");
    $('.containermsg').css("border-radius", "0");
    $('#menu').css("animation","slide-out 0.1s linear").css("animation-fill-mode","forwards");
    burger();
    setTimeout(function(){ $('#menu').css("display","none");}, 100); 
    click = 0;
  }
}

$(document).mouseup(function(e) {
  var container = $("#banner");

  if (!container.is(e.target) // if the target of the click isn't the container...
    && container.has(e.target).length === 0) // ... nor a descendant of the container
  {
    $("#banner").css("background", "#4285f4");
    click--;
    burger();
    $('.icon').attr("src", "//ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/ic_search_wht_24dp_r1.png");
    $('#inbox').css("color", "white").text("Inbox");
  }
});

$(function() {
  $('[data-toggle="tooltip"]').tooltip()
});

$('.switch').click(function() {
  if ($("#switch-on").is(':checked')) {
    $(".switch").css("background", "#EEE");
    $('#inbox').css("color", "white").text("Notes");
    $(".toggle").css("background", "white");
    $(".toggleimg").attr("src", "//ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_pin_toggle_on_15dp_r3.png");
    $("#notes").css("display", "block");
  } else {
    $(".switch").css("background", "#3262ba");
    $(".toggle").css("background", "#4285f4");
    $('#inbox').css("color", "white").text("Inbox");
    $(".toggleimg").attr("src", "//ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_pin_toggle_off_15dp_r3.png");
    $("#notes").css("display", "none");
  }
});

function postponed()
{
  $('#inbox').text("Postponed");
  $('#banner').css("background",'#eca403');
  $('#postponed').show();
  $(".switch").hide();
  $( "#switch-off" ).prop( "checked", true );
}

function completed()
{
  $('#inbox').text("Completed");
  $('#banner').css("background",'#0f9d58');
  $(".switch").hide();
}

function inbox(){
  $('#inbox').text("Inbox");
  $('#banner').css("background",'#4285f4');
  $(".switch").show();
  $("#notes").hide();
  $("#postponed").hide();
  $("#completed").hide();
  arrow();
}

function newmail(){
    $("#newmail").show();
}