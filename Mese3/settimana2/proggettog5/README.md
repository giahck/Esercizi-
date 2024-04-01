# Progetto m3-s2-g5
la parte funzionale si svolge tutto sulla home, e con i due service
é stato progettato che: dopo il caricamento degli utenti sotto alla barra di ricerca per nome(ricerca fatta in two way binding,quindi viene filtrato l'arrey degli utenti ad ogni lettera inserita), clicando sopra al nome dell'utente  si visualizzano tutti i post sia quelli attivi che quelli disattivi, inalto dopo il caricamento 
vengono attivati tre pulsanti uno che visualizza tutti i post uno che visualizza solo quelli disattivi e uno solo quelli attivi, clicando sopra al post il post diventa o disattivo o attivo in base a come é stato caricato gia clicato(se é rosso e dissattivo se é blue é attivo),
nella nav clicando su login e poi register si va nella paggina di registrazione ma non é ancora funzionante, arrivano solo i dati inseriti ma fitizzi
la prima cosa che fa é caricare i dati! tramite httprequest dal serivice http-request, i dati vengono caricati nel secondo service persona e poi da li vengono richiamati sulla home
