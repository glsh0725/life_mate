        const openModalBtn = document.getElementById('termsAgree');
        const modal = document.getElementById('myModal');
        const closeBtn = document.querySelector('.close-btn');

        function openModal() {
            modal.style.display = 'block';
        }

        function closeModal() {
            modal.style.display = 'none';
        }

        openModalBtn.addEventListener('click', openModal);
        closeBtn.addEventListener('click', closeModal);

        window.addEventListener('click', function(event) {
            if (event.target === modal) {
                closeModal();
            }
        });