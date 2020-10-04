// nazywamy nasze cache- w zmiennej będzie wygodniej
const MY_CACHE = 'cache-name';
// w tej tablicy lądują wszystkie pliki, które chcemy dodać do cache
const MY_FILES = [
    '../css/bg1.css',
    '../css/bg2.css',
    '../css/bg3.css',
    '../css/bg4.css',
    '../css/buttons1.css',
    '../css/buttons2.css',
    '../css/form.css',
    '../css/gears.css',
    '../css/loginform.css',
    '../css/selectbox.css',
    '../css/style.css',
    '../img/bg.jpg',
    '../img/bg2.jpg',
    '../img/bg3.jpg',
    '../img/bg4.jpg',
    '../img/meta-logo.jpg',
    '../img/gear.png',
    'loginForm.js',
    'newExpenseForm.js',
    'newFuelExpenseForm.js',
    'newVehicleForm.js',
    'range-slider.js',
    'vehiclePage.js'
];

// instalujemy nasz service worker
self.addEventListener('install', function(event) {
    event.waitUntil(
        caches.open(MY_CACHE).then(function(cache) {
            return cache.addAll(MY_FILES);
        })
    );
});
// po aktywacji chcę skasować wszystkie cache w naszej domenie, które nie są naszym cache (to opcjonalne)
self.addEventListener('activate', function(event) {
    event.waitUntil(
        caches.keys().then(function(cacheNames) {
            return Promise.all(
                cacheNames.filter(function(cacheName) {
                    return cacheName !== MY_CACHE;
                }).map(function(cacheName) {
                    return caches.delete(cacheName);
                })
            );
        })
    );
});
// strategia 'Network falling back to cache'
self.addEventListener('fetch', function(event) {
    event.respondWith(
        fetch(event.request).catch(function() {
            return caches.match(event.request);
        })
    );
});