import React from 'react';
import {Navbar} from "react-bootstrap";
import {Nav} from "react-bootstrap";
import {Link} from "react-router-dom";

const NavbarComponent = () => {
    return (
        <Navbar bg="primary" variant="dark">
            <Navbar.Brand as={Link} to={"/"}>Aqua park</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link as={Link} to="/Guests">Guests</Nav.Link>
                <Nav.Link as={Link} to="/Slides">Slides</Nav.Link>

                {/*
                    Ez mindig újra tölti az oldalt
                        <Nav.Link href="/Guests">Guests</Nav.Link>
                        <Nav.Link href="/Slides">Slides</Nav.Link>
                */}
            </Nav>
        </Navbar>
    )
}

export default NavbarComponent;