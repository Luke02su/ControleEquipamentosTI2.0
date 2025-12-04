document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('fk_num_serie');
    const icon = document.getElementById('cameraIconPlaca');
    const area = document.getElementById('scanner-area2');
    let scanning = false;

    if (!input || !icon || !area) {
        console.warn("Scanner: elementos não encontrados no DOM.");
        return;
    }

    const config = {
        inputStream: {
            name: "Live",
            type: "LiveStream",
            target: document.querySelector('#interactive2'),
            constraints: {
                width: { ideal: 1280 },
                height: { ideal: 720 },
                facingMode: "environment",

                advanced: [{ 
                    zoom: 2.0, 
                    exposureMode: "continuous" 
                 }]
            }
        },
        locator: {
            patchSize: "medium",
            halfSample: true
        },
        area: {
            top: "25%", 
            bottom: "75%", 
            left: "25%", 
            right: "25%"
        },
        decoder: {
            readers: ["ean_reader", "code_128_reader", "upc_reader", "code_39_reader"]
        },
        locate: true
    };

    function startScanner() {
        area.style.display = 'block';
        scanning = true;
        Quagga.init(config, err => {
            if (err) {
                console.error("Erro ao iniciar scanner:", err);
                alert("Erro ao acessar a câmera. Verifique as permissões.");
                area.style.display = 'none';
                scanning = false;
                return;
            }
            Quagga.start();
        });
    }

    function stopScanner(code = null) {
        if (!scanning) return;
        try { Quagga.stop(); } catch {}
        area.style.display = 'none';
        scanning = false;
        if (code) input.value = code;
    }

    icon.addEventListener('click', () => scanning ? stopScanner() : startScanner());
    Quagga.onDetected(data => stopScanner(data.codeResult.code));
});
