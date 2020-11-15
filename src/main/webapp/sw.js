importScripts('/VAADIN/static/server/workbox/workbox-sw.js');

workbox.setConfig({
    modulePathPrefix: '/VAADIN/static/server/workbox/'
});
workbox.precaching.precacheAndRoute([
    {url: 'icons/logo-144x144.png', revision: '-1637032553'},
    {url: 'icons/logo-192x192.png', revision: '776867745'},
    {url: 'icons/logo-512x512.png', revision: '-137838484'},
    {url: 'icons/logo-16x16.png', revision: '-583391155'},
    {url: 'offline.html', revision: '-1012252990'},
    {url: 'manifest.json'},
    {url: 'images/car.png'},
    {url: 'images/car2.png'},
    {url: 'images/man.png'},
    {url: 'icon/motorcycle.svg'},
    {url: 'icon/motorcycle-i.svg'},
    {url: 'icon/car-wash.svg'},
    {url: 'icon/maintenance.svg'},
    {url: 'icon/tow.svg'},
    {url: 'icon/body-paint-repair.svg'},
    {url: 'images/bg-03.png'},
    {url: 'images/logo-i.png'},
    {url: 'images/logo.png'}
]);
self.addEventListener('fetch', function (event) {
    var request = event.request;
    if (request.mode === 'navigate') {
        event.respondWith(
            fetch(request)
                .catch(function () {
                    return caches.match('offline.html');
                })
        );
    }
});