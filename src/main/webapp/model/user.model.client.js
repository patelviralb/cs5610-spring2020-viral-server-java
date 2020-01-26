function User(username, password, firstName, lastName, role) {
  var self = this;
  self.username = username;
  self.password = password;
  self.firstName = firstName;
  self.lastName = lastName;
  self.role = role;

  /*self.setUsername = setUsername;
  self.getUsername = getUsername;
  // ...same for rest of properties…*/

  function setUsername(username) {
    self.username = username;
  }
  function getUsername() {
    return self.username;
  }

  function setPassword(password) {
    self.password = password;
  }
  function getPassword() {
    return self.password;
  }

  function setFirstName(firstName) {
    self.firstName = firstName;
  }
  function getFirstName() {
    return self.firstName;
  }

  function setLastName(lastName) {
    self.lastName = lastName;
  }
  function getLastName() {
    return self.lastName;
  }

  function setRole(role) {
    self.role = role;
  }
  function getRole() {
    return self.role;
  }
}
