document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('fk_num_serie');
    const icon = document.getElementById('cameraIcon');
    const area = document.getElementById('scanner-area');
    let scanning = false;

    if (!input || !icon || !area) {
        console.warn("Scanner: elementos não encontrados no DOM.");
        return;
    }

    const config = {
        inputStream: {
            name: "Live",
            type: "LiveStream",
            target: document.querySelector('#interactive'),
            constraints: {
                width: { ideal: 1280 },
                height: { ideal: 720 },
                facingMode: "environment"
            }
        },
        locator: {
            patchSize: "medium",
            halfSample: true
        },
        area: {
            top: "50%",    // corta 25% de cima
            right: "25%",  // corta 25% da direita
            left: "25%",   // corta 25% da esquerda
            bottom: "50%"  // corta 25% de baixo
        },
        decoder: {
            readers: ["ean_reader", "code_128_reader", "upc_reader"]
        },
        locate: true
    };

    function startScanner() {
        area.style.display = 'block';
        scanning = true;
        Quagga.init(config, err => {
            if (err) {
                console.error("Erro ao iniciar scanner:", err);
                alert("Erro ao acessar a câmera. Verifique as permissões ou use HTTPS.");
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
