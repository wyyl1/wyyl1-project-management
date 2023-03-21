// 选中菜单
function selectedMenu() {
    let currentUrl = window.location.href;
    let allHrefs = $('nav.mt-2 a[href]');

    allHrefs.each(function () {
        let href = $(this).attr('href');
        href = noParameterUrl(href);

        if (currentUrl.indexOf(href) !== -1) {
            $(this).addClass('active');
        }
    });
}

function noParameterUrl(url) {
    let index = url.indexOf('?');

    if (index !== -1) {
        return url.substring(0, index);
    }

    return url;
}