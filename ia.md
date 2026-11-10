# IA.md - TP 2, application Web - Hadil Maghnaoui

**Outil utilisé :** Claude (Anthropic), sur le site claude.ai.

## 1. Le rôle système et la mémoire

**Problème rencontré :** Je ne savais pas comment faire pour que le LLM prenne en compte le rôle système.

**Pourquoi j'ai utilisé l'IA :** Je n'avais pas bien compris comment ajouter le rôle dans la mémoire.

**Prompt utilisé :** "Le TP demande de vider la mémoire puis d'ajouter un SystemMessage : c'est le rôle de setSystemRole. Passer seulement le texte du rôle ne suffit pas, il faut l'ajouter à la mémoire pour que le LLM en tienne compte. comment je fais ça"

**Réponse de l'IA :** Il faut d'abord vider la mémoire avec `chatMemory.clear()`, puis ajouter le rôle avec `chatMemory.add(SystemMessage.from(systemRole))`.

**Ce que j'ai appris :** J'ai compris que le rôle système doit être ajouté à la mémoire pour être pris en compte par le LLM. J'ai aussi compris que lorsqu'on change le rôle, il faut vider l'ancienne mémoire.

## 2. Modifier le backing bean (Bb)

**Problème rencontré :** Mon Bb du TP 1 contenait encore des éléments du mode debug et utilisait JsonAdapterPourGemini.

**Pourquoi j'ai utilisé l'IA :** Je ne savais pas quelles parties supprimer pour l'adapter au TP 2.

**Prompt utilisé :** J'ai envoyé mon code Bb et demandé "corrige".

**Réponse de l'IA :** L'IA m'a proposé un Bb sans le mode debug et avec `@Inject LlmClient`. Elle m'a aussi montré comment utiliser `setSystemRole()` et `envoyerRequete()`.

**Ce que j'ai appris :** J'ai compris qu'on n'utilise plus directement le JSON comme dans le TP 1. Maintenant, le Bb passe par LlmClient pour envoyer les questions et recevoir les réponses.

## 3. Modifier la page index.xhtml

**Problème rencontré :** Ma page contenait encore les éléments du mode debug du TP 1.

**Pourquoi j'ai utilisé l'IA :** Je voulais savoir quoi supprimer sans provoquer d'erreurs.

**Prompt utilisé :** J'ai envoyé mon code index.xhtml du TP 1.

**Réponse de l'IA :** L'IA m'a indiqué de supprimer le panneau qui affichait les requêtes et réponses JSON ainsi que le bouton du mode debug.

**Ce que j'ai appris :** J'ai compris que la page XHTML doit correspondre aux propriétés du Bb. Si on supprime une propriété dans le Bb, il faut aussi retirer les éléments de la page qui l'utilisent.

## 4. Vérifier LlmClient

**Problème rencontré :** Je voulais vérifier si ma classe LlmClient était complète.

**Prompt utilisé :** J'ai envoyé mon code LlmClient pour le vérifier.

**Réponse de l'IA :** L'IA m'a expliqué que je devais avoir l'interface Assistant dans le même package et que la clé GEMINI_KEY devait être accessible par Payara.

**Ce que j'ai appris :** J'ai compris que LlmClient a besoin de l'interface Assistant pour fonctionner et que la clé API doit être correctement configurée pour pouvoir communiquer avec Gemini.