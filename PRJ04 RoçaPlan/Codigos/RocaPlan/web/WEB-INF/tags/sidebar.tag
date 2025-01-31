<%@tag description="Sidebar" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="cp" required="true"%>
<%@attribute name="activeItemIndex" required="true"%>

<%-- any content can be specified here e.g.: --%>
<aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
    <div class="app-brand demo">
        <a href="${cp}/index.jsp" class="app-brand-link">
            <span class="app-brand-logo demo">
                <img src="${cp}/img/logo/logo.svg" alt="Logo RoçaPlan" />
            </span>
            <span class="app-brand-text demo menu-text fw-bold ms-2">RoçaPlan</span>
        </a>

        <a href="javascript:void(0);"
           class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
            <i class="bx bx-chevron-left bx-sm d-flex align-items-center justify-content-center"></i>
        </a>
    </div>

    <div class="menu-inner-shadow"></div>

    <ul class="menu-inner py-1">
        <li class="menu-item ${activeItemIndex == 1 ? "active" : ""}">
            <a href="${cp}/index.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-home-smile"></i>
                <div class="text-truncate">Dashboard</div>
            </a>
        </li>

        <li class="menu-item ${activeItemIndex == 2 ? "active" : ""}">
            <a href="${cp}/pages/expenses.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-cart-download"></i>
                <div class="text-truncate">Despesas</div>
            </a>
        </li>

        <li class="menu-item ${activeItemIndex == 3 ? "active" : ""}">
            <a href="${cp}/pages/products.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-box"></i>
                <div class="text-truncate">Produtos</div>
            </a>
        </li>

        <li class="menu-item ${activeItemIndex == 4 ? "active" : ""}">
            <a href="${cp}/pages/sales.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-money-withdraw"></i>
                <div class="text-truncate">Vendas</div>
            </a>
        </li>

        <li class="menu-item mt-auto">
            <a href="${cp}/pages/login.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-power-off"></i>
                <div class="text-truncate">Sair</div>
            </a>
        </li>
    </ul>
</aside>