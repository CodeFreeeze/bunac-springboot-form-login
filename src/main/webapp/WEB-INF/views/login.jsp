<html>
<head></head>
<body>

    <div th:if="${param.error}">
    ${param.error}
      Invalid username and password. ${param.error}
    </div>
    <div th:if="${param.logout}">
      You have been logged out. ${param.logout}
    </div>

   <h1>Login</h1>
   <form name='f' action="/login" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html