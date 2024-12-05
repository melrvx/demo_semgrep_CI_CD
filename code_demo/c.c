#include <stdio.h>
#include <string.h>

void authentification() {
    char nomUtilisateur[20];
    char motDePasse[10];
    int accesAutorise = 0;

    printf("Entrez votre nom d'utilisateur : ");
    if (fgets(nomUtilisateur, sizeof(nomUtilisateur), stdin) != NULL) {
        nomUtilisateur[strcspn(nomUtilisateur, "\n")] = '\0'; // Supprimer le saut de ligne
    } else {
        printf("Erreur lors de la lecture du nom d'utilisateur.\n");
        return;
    }

    printf("Entrez votre mot de passe : ");
    scanf("%s", motDePasse); // Vulnérabilité ici

    if (strcmp(nomUtilisateur, "admin") == 0 && strcmp(motDePasse, "secret") == 0) {
        printf("Authentification réussie !\n");
        accesAutorise = 1;
    } else {
        printf("Nom d'utilisateur ou mot de passe incorrect.\n");
    }

    if (accesAutorise) {
        printf("Accès autorisé.\n");
    } else {
        printf("Accès refusé.\n");
    }
}

int main() {
    authentification();
    return 0;
}