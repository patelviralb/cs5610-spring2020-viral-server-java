(function () {
  let userService = new AdminUserServiceClient();
  let $usernameFld, $passwordFld, $firstNameFld, $lastNameFld, $roleFld;
  let $addUserBtn, $updateUserBtn, $searchUserBtn;
  let $tableBody, $rowTemplate;

  /**
   * Functions required as per document.
   */
  const main = () => {
    $tableBody = $('tbody');
    $rowTemplate = $('.vp-cs5610-row-template');

    $usernameFld = $('#usernameFld');
    $passwordFld = $('#passwordFld');
    $firstNameFld = $('#firstNameFld');
    $lastNameFld = $('#lastNameFld');
    $roleFld = $('#roleFld');

    $addUserBtn = $('#addUserBtn');
    $updateUserBtn = $('#updateUserBtn');
    $searchUserBtn = $('#searchUserBtn');

    findAllUsers();

    $addUserBtn.click(createUser);
    $searchUserBtn.click(searchUser);
  };

  const createUser = () => {
    let user = makeUserData();
    userService.createUser(user).then(renderUser);

    clearAllFields();
  };

  const findAllUsers = () => {
    userService.findAllUsers().then(renderUsers);
  };

  const findUserById = (userID) => {
    userService.findUserById(userID).then(selectUser);
  };

  const deleteUser = (userID) => {
    userService.deleteUser(userID).then(() => removeRow(userID))
  };

  const selectUser = (userData) => {
    $usernameFld.val(userData.username);
    $passwordFld.val(userData.password);
    $firstNameFld.val(userData.firstName);
    $lastNameFld.val(userData.lastName);
    $roleFld.val(userData.role);

    $updateUserBtn.click(() => updateUser(userData));

    $updateUserBtn.attr('disabled', false);
    $updateUserBtn.removeClass("btn-secondary");
    $updateUserBtn.addClass("btn-success");

    $addUserBtn.attr('disabled', true);
    $addUserBtn.removeClass("btn-success");
    $addUserBtn.addClass("btn-secondary");
  };

  const updateUser = (userData) => {
    let user = makeUserData();
    userService.updateUser(userData._id, user).then(() => {
      userService.findUserById(userData._id).then(renderUpdatedUser);
    });

    $updateUserBtn.attr('disabled', true);
    $updateUserBtn.addClass("btn-secondary");
    $updateUserBtn.removeClass("btn-success");
    $updateUserBtn.unbind("click");

    $addUserBtn.attr('disabled', false);
    $addUserBtn.addClass("btn-success");
    $addUserBtn.removeClass("btn-secondary");
  };

  const renderUser = (user) => {
    const rowToClone = $rowTemplate.clone();

    rowToClone.removeClass('vp-cs5610-row-template-hidden');
    rowToClone.removeClass('vp-cs5610-row-template');
    rowToClone.attr('id',"vp-cs5610-user-row-" + user._id);
    rowToClone.find('.vp-cs5610-template-username').html(user.username);
    rowToClone.find('.vp-cs5610-template-password').html(user.password);
    rowToClone.find('.vp-cs5610-template-firstName').html(user.firstName);
    rowToClone.find('.vp-cs5610-template-lastName').html(user.lastName);
    rowToClone.find('.vp-cs5610-template-role').html(user.role);
    rowToClone.find('.vp-cs5610-template-delete-btn').click(() => deleteUser(user._id));
    rowToClone.find('.vp-cs5610-template-edit-btn').click(() => findUserById(user._id));
    $tableBody.prepend(rowToClone);
  };

  const renderUsers = (allUsers) => {
    $tableBody.empty();

    for(var userIndex in allUsers) {

      const eachUser = allUsers[userIndex];
      renderUser(eachUser);
    }
  };

  /**
   * Helper functions
   */
  const makeUserData = () => {
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

    return user;
  };

  const removeRow = (userID) => {
    let $elementToRemove = $(`#vp-cs5610-user-row-${userID}`);
    $elementToRemove.remove();

    clearAllFields();
  };

  const renderUpdatedUser = (userData) => {
    let elementToUpdate = $(`#vp-cs5610-user-row-${userData._id}`);
    elementToUpdate.remove();
    renderUser(userData);

    clearAllFields();
  };

  const clearAllFields = () => {
    $usernameFld.val("");
    $passwordFld.val("");
    $firstNameFld.val("");
    $lastNameFld.val("");
    $roleFld.prop('selectedIndex',0);
  };

  const searchUser = () => {
    userService.findAllUsers().then(renderFilteredUser);
  };

  const renderFilteredUser = (users) => {
    let username = $usernameFld.val();
    let firstName = $firstNameFld.val();
    let lastName = $lastNameFld.val();
    let role = $roleFld.val();

    /*console.log(users);*/
    let filteredArray = users;

    if (username !== ""){
      filteredArray = filteredArray.filter(filterUserName => filterUserName.username === username);
    }
    if (firstName !== ""){
      filteredArray = filteredArray.filter(filterUserName => filterUserName.firstName === firstName);
    }
    if (lastName !== ""){
      filteredArray = filteredArray.filter(filterUserName => filterUserName.lastName === lastName);
    }
    if (role !== "none"){
      filteredArray = filteredArray.filter(filterUserName => filterUserName.role === role);
    }

    /*console.log(filteredArray);*/
    console.log(filteredArray.length);
    if(filteredArray.length != 0) {
      renderUsers(filteredArray);
    } else {
      renderUsers(users);
      $('#vp-cs5610-no-user-found-error').removeClass("d-none");
      setTimeout(() => {$('#vp-cs5610-no-user-found-error').addClass("d-none")},1500);

      /*$('#vp-cs5610-no-user-found-error').addClass("d-none");*/
      /*alert("Kool");*/
    }
    clearAllFields();
  };

  $(main);
})();