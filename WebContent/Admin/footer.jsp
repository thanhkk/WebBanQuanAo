<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


</div>
</div>
</div>
</main>
<footer>
	<div class="footer-copyright offset-sm-2">© 2018 Copyright:
		thanhtv</div>
</footer>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
		
	});
	 function readURL(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();

             reader.onload = function (e) {
                 $('#imgSP')
                     .attr('src', e.target.result);
             };

             reader.readAsDataURL(input.files[0]);
         }
     }
</script>
</body>

</html>