function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;

  this.url = 'https://wbdv-generic-server.herokuapp.com/api/001374158/users';

  const self = this;

  function createUser(user) {
    return fetch(self.url, {
      method: 'POST',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(user)
    }).then(response => response.json())
  }

  function findAllUsers() {
    return fetch(self.url).then(response => response.json())
  }

  function findUserById(userID) {
    return fetch(`${self.url}/${userID}`).then(response => response.json())
  }

  function updateUser(userID, user) {
    return fetch(`${self.url}/${userID}`, {
      method: 'PUT',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(user)
    }).then(response => response.json())
  }

  function deleteUser(userId) {
    return fetch(`${self.url}/${userId}`, {
      method: 'DELETE'
    }).then(response => response.json())
  }
}
