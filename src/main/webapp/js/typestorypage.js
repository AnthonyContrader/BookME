new Vue({
  el: '#app',
  data: {
    max: 500,
    text: '' },

  computed: {
    counter() {
      return this.text.length;
    } } });

    $(document).ready(function(){
      $('.nice-textbox').blur(function() {
           if($(this).val().length === 0){
             $('.nice-label').removeClass("focus");
           }
           else { returns; }
         })
         .focus(function() {
           $('.nice-label').addClass("focus")
         });
   });