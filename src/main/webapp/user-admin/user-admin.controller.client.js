(function () {
  /*var $usernameFld, $passwordFld;
  var $removeBtn, $editBtn, $createBtn;
  var $firstNameFld, $lastNameFld, $roleFld;
  var $userRowTemplate, $tbody;
  var userService = new AdminUserServiceClient();
  $(main);*/

  /*function main() { … }
  DONE//function createUser() { … }
  DONE//function findAllUsers() { … }
  function findUserById() { … }
  DONE//function deleteUser() { … }
  function selectUser() { … }
  function updateUser() { … }
  function renderUser(user) { … }
  DONE//function renderUsers(users) { … }*/

  let userService = new AdminUserServiceClient();
  let $usernameFld, $passwordFld, $firstNameFld, $lastNameFld, $roleFld;
  let $addUserBtn, $updateUserBtn;
  let $tableBody, $rowTemplate;

  const main = () => {
    $tableBody = $('tbody');
    $rowTemplate = $('.vp-cs5610-row-template');
    $addUserBtn = $('#addUserBtn');
    $updateUserBtn = $('#updateUserBtn');

    findAllUsers();

    $addUserBtn.click(createUser);
  };

  const findAllUsers = () => {
    userService.findAllUsers().then(renderUsers);
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

    userService.createUser(user).then(renderUser);
  };

  const renderUsers = (allUsers) => {
    $tableBody.empty();

    for(var userIndex in allUsers) {

      const eachUser = allUsers[userIndex];
      const rowToClone = $rowTemplate.clone();

      rowToClone.removeClass('vp-cs5610-row-template-hidden');
      rowToClone.attr('id',eachUser._id);
      rowToClone.find('.vp-cs5610-template-username').html(eachUser.username);
      rowToClone.find('.vp-cs5610-template-password').html(eachUser.password);
      rowToClone.find('.vp-cs5610-template-firstName').html(eachUser.firstName);
      rowToClone.find('.vp-cs5610-template-lastName').html(eachUser.lastName);
      rowToClone.find('.vp-cs5610-template-role').html(eachUser.role);
      rowToClone.find('.vp-cs5610-template-delete-btn').click(() => deleteUser(eachUser._id));
      /*rowToClone.find('.vp-cs5610-template-edit-btn').click(() => #(eachUser._id));*/
      $tableBody.append(rowToClone);
    }
  };

  const deleteUser = (userID) => {
    userService.deleteUser(userID).then(() => removeRow(userID))
  };

  const removeRow = (userID) => {
    let $elementToRemove = $(`#${userID}`);
    $elementToRemove.remove();
  }

  const renderUser = (user) => {
    console.log(user);
    const rowToClone = $rowTemplate.clone();

    rowToClone.removeClass('vp-cs5610-row-template-hidden');
    rowToClone.find('.vp-cs5610-template-username').html(user.username);
    rowToClone.find('.vp-cs5610-template-password').html(user.password);
    rowToClone.find('.vp-cs5610-template-firstName').html(user.firstName);
    rowToClone.find('.vp-cs5610-template-lastName').html(user.lastName);
    rowToClone.find('.vp-cs5610-template-role').html(user.role);
    rowToClone.find('.vp-cs5610-template-delete-btn').click(() => deleteUser(user._id));
    /*rowToClone.find('.vp-cs5610-template-edit-btn').click(() => #(user._id));*/
    $tableBody.prepend(rowToClone);
  };

  $(main);
})();