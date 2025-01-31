<%@tag description="Header" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="cp" required="true"%>
<%@attribute name="title" required="true"%>

<%-- any content can be specified here e.g.: --%>
<meta charset="UTF-8" />
<meta
    name="viewport"
    content="width=device-width,initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>RoçaPlan - ${title}</title>

<meta name="description" content="O Sistema de Gestão da Roça" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon" href="${cp}/img/logo/favicon.ico" />

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
    href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
    rel="stylesheet" />
<link rel="stylesheet" href="${cp}/fonts/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet" href="${cp}/css/libs/bootstrap/core.css" class="template-customizer-core-css" />
<link rel="stylesheet" href="${cp}/css/theme-default.css" class="template-customizer-theme-css" />
<link rel="stylesheet" href="${cp}/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet" href="${cp}/css/libs/perfect-scrollbar/perfect-scrollbar.css" />

<!-- Helpers -->
<script src="${cp}/js/helpers.js"></script>

<!-- Config  -->
<script src="${cp}/js/config.js"></script>