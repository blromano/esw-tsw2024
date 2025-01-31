<%@tag description="Navbar" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="cp" required="true"%>

<%-- any content can be specified here e.g.: --%>
<nav
    class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
    id="layout-navbar">
    <div
        class="layout-menu-toggle navbar-nav align-items-xl-center me-4 me-xl-0 d-xl-none">
        <a class="nav-item nav-link px-0 me-xl-6"
           href="javascript:void(0)">
            <i class="bx bx-menu bx-md"></i>
        </a>
    </div>

    <div class="d-flex align-items-center ms-auto">
        <div class="flex-shrink-0 me-2">
            <img src="${cp}/img/avatars/1.png" alt="User Image"
                 class="w-px-30 h-auto rounded-circle" />
        </div>
        <h6 class="mb-0">Francisco Silva</h6>
    </div>
</nav>