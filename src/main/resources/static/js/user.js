const urlUsers = 'http://localhost:8080/api/users'

navbarAndUserInfoPage()

function navbarAndUserInfoPage(){
    const elementNavbar = document.getElementById('Navbar')
    const elementUserInfoPage = document.getElementById('userInfoPage')

    fetch(urlUsers + '/authUser')
        .then(response => response.json())
        .then(authUser => {
            elementNavbar.textContent = `${authUser.firstName} with roles: ${authUser.roles.map(a => a.name).map(name => name.replace("ROLE_", ""))}`
            elementUserInfoPage.innerHTML = `
                <tr>
                    <td>${authUser.firstName}</td>
                    <td>${authUser.lastName}</td>
                    <td>${authUser.email}</td>
                    <td>${authUser.roles.map(r => " " + r.name).map(name => name.replace("ROLE_", ""))}</td>
                </tr>`
        })
}