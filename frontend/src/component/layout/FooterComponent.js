import React from 'react';

const FooterComponent = () => {
    return (
        <footer id='footer' className={"page-footer bg-primary text-light mt-5"} style={{position: "relative", bottom: "0"}}>
            <div className={"footer-copyright text-center py-3"}>
                {new Date().getFullYear()} Copyright &copy; Aquapark - Designed by our little team
            </div>
        </footer>
    )
}

export default FooterComponent;