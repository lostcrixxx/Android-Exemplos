    private static final int REQUEST_CODE_PERMISSIONS = 123;
    private String[] permissions = {Manifest.permission.CAMERA};

    // Verificar e solicitar permissões quando o fragmento for criado
    verificarEConcederPermissoes();

    // Método para verificar e conceder permissões
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarEConcederPermissoes() {
        if (temPermissoes()) {
            // Se as permissões já foram concedidas, faça o que precisa aqui
            Toast.makeText(requireContext(), "Permissões concedidas. Faça o que você precisa.", Toast.LENGTH_SHORT).show();
        } else {
            // Se as permissões ainda não foram concedidas, solicite-as
            requestPermissions(permissions, REQUEST_CODE_PERMISSIONS);
        }
    }

    // Método para verificar se as permissões já foram concedidas
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean temPermissoes() {
        for (String permission : permissions) {
            if (requireContext().checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    // Método chamado após o usuário responder à solicitação de permissões
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            // Verificar se as permissões foram concedidas
            boolean todasPermissoesConcedidas = true;

            for (int resultado : grantResults) {
                if (resultado != PackageManager.PERMISSION_GRANTED) {
                    todasPermissoesConcedidas = false;
                    break;
                }
            }

            if (todasPermissoesConcedidas) {
                // Permissões concedidas, faça o que precisa fazer aqui
                Toast.makeText(requireContext(), "Permissões concedidas. Faça o que você precisa.", Toast.LENGTH_SHORT).show();
            } else {
                // Alguma permissão foi negada, trate conforme necessário
                Toast.makeText(requireContext(), "Permissões negadas. Algumas funcionalidades podem não funcionar.", Toast.LENGTH_SHORT).show();
            }
        }
    }