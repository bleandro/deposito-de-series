import React, { Component } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import "./Login.css";
import $ from "jquery";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      login: "",
      password: "",
      userAuthenticatedSuccesfully: null
    };
  }

  validateForm() {
    return this.state.login.length > 0 && this.state.password.length > 0;
  }

  handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value
    });
  }

  handleSubmit = event => {
    event.preventDefault();

    let login = this.state.login;
    let password = this.state.password;

    $.ajax({
      method: "POST",
      url: "http://localhost:9998/users/signin",
      dataType: "json",
      contentType: 'application/json',
      data: JSON.stringify({ login, password }),
      success: function(response) {
        console.log(response)
        this.setState({userAuthenticatedSuccesfully: response.userAuthenticatedSuccesfully})
      }.bind(this)
    })
  }

  loginResult() {
    let result = {}

    if (this.state.userAuthenticatedSuccesfully != null)
    {
      result.variant = (this.state.userAuthenticatedSuccesfully) ? "success" : "danger";
      result.message = (this.state.userAuthenticatedSuccesfully) ? "Login realizado com sucesso" : "Erro no login";
    }

    return result;
  }

  render() {
    return (
      <div className="Login">
        <form onSubmit={this.handleSubmit}>
          <Form.Group controlId="login">
            <Form.Label>Login</Form.Label>
            <Form.Control
              autoFocus
              type="text"
              value={this.state.login}
              onChange={this.handleChange}
            />
          </Form.Group>
          <Form.Group controlId="password">
            <Form.Label>Password</Form.Label>
            <Form.Control
              value={this.state.password}
              onChange={this.handleChange}
              type="password"
            />
          </Form.Group>
          <Button
            block
            disabled={!this.validateForm()}
            type="submit"
          >
            Login
          </Button>

          {
            (Object.keys(this.loginResult()).length > 0) ?
            <Alert className="LoginResult" variant={this.loginResult().variant}>
              {this.loginResult().message}
            </Alert>
            : null
          }
        </form>
      </div>
    );
  }
}
