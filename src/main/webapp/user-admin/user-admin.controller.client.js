(function () {
  /*var $usernameFld, $passwordFld;
  var $removeBtn, $editBtn, $createBtn;
  var $firstNameFld, $lastNameFld, $roleFld;
  var $userRowTemplate, $tbody;
  var userService = new AdminUserServiceClient();
  $(main);*/

  /*function main() { … }
  DONE//function createUser() { … }
  function findAllUsers() { … }
  function findUserById() { … }
  function deleteUser() { … }
  function selectUser() { … }
  function updateUser() { … }
  function renderUser(user) { … }
  function renderUsers(users) { … }*/

  let userService = new AdminUserServiceClient();
  let $usernameFld, $passwordFld, $firstNameFld, $lastNameFld, $roleFld;
  let $addUserBtn, $updateUserBtn;
  let $tableBody, $rowTemplate;

  const main = () => {
    $tableBody = $('tbody');
    $rowTemplate = $('#vp-cs5610-row-template');
    $addUserBtn = $('#addUserBtn');
    $updateUserBtn = $('#updateUserBtn');

    userService.findAllUsers().then(renderUsers);

    $addUserBtn.click(createUser);
  };

  const createUser = () => {
    $usernameFld = $('#usernameFld');
    $passwordFld = $('#passwordFld');
    $firstNameFld = $('#firstNameFld');
    $lastNameFld = $('#lastNameFld');
    $roleFld = $('#roleFld');

    let username = $usernameFld.val();
    let password = "####Encrypted####";
    let firstName = $firstNameFld.val();
    let lastName = $lastNameFld.val();
    let role = $roleFld.val();

    let user = {
      "username" : username,
      "password" : password,
      "firstName" : firstName,
      "lastName" : lastName,
      "role" : role
    };

    userService.createUser(user).then(renderUsers);
  };

  const renderUsers = (allUsers) => {
    $tableBody.empty();

    for(var userIndex in allUsers) {

      const eachUser = allUsers[userIndex];
      const rowToClone = $rowTemplate.clone();

      rowToClone.removeClass('vp-cs5610-row-template-hidden');
      rowToClone.find('.vp-cs5610-template-username').html(eachUser.username);
      rowToClone.find('.vp-cs5610-template-password').html(eachUser.password);
      rowToClone.find('.vp-cs5610-template-firstName').html(eachUser.firstName);
      rowToClone.find('.vp-cs5610-template-lastName').html(eachUser.lastName);
      rowToClone.find('.vp-cs5610-template-role').html(eachUser.role);
      $tableBody.append(rowToClone);
    }
  };

  const testClick = () => {
    alert("Done")
  };
  $(main);


})();