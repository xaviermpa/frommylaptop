<script>

function formshide()
{
document.getElementById("signin").style.display="block";
document.getElementById("signup").style.display="block";
location.reload();
}

  function sup(b)
  {
      if(b==1)
          document.getElementById("signup").style.display="inline";
      else
        document.getElementById("signup").style.display="block";
      
  }
  
  function sin(a)
  {
       if(a==1)
          document.getElementById("signin").style.display="inline";
        else 
          document.getElementById("signin").style.display="block";
         
  }
  
  </script>
