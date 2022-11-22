/**
 * Jquery Plugin
 * toggleShowHideTarget
 * version 1.0
 * Author: Gaetano Erizian
 *
 * Plugin per nascondere e mostrare, nascondere solamente o mostrare solamente elementi come specificati in attributi
 * data-target-hide => Elemento da nascondere
 * data-target-show => Elemento da mostrare
 *
 * Il plugin può essere incluso direttamente nella pagina e tutti gli elementi del dom che presentano la classe
 * .toggleShowHideTarget
 * Saranno ciclati dal plugin per applicare i metodi ed i comportamenti descritti
 *
 * -----------------------------------------------------
 * ESEMPIO 1:
 * Se nella pagina abbiamo un elemento:
 * <a href="#" class="toggleShowHideTarget" data-target-hide="#targetHide" data-target-show="#targetShow">Clicca qui</a>
 * Cliccando sul link appena descritto verranno prima nascosti gli elementi specificati come selettori css in data-target-hide
 * (in questo caso un elemento con id="targetHide") e successivamente mostrati gli elementi specificati in data-target-show
 * (in questo caso un elemento con id="targetShow").
 * -----------------------------------------------------
 * ESEMPIO 2:
 * Se nella pagina abbiamo un elemento:
 * <a href="#" class="toggleShowHideTarget" data-target-hide="#targetHide">Clicca qui</a>
 * Cliccando sul link appena descritto verranno solamente nascosti gli elementi specificati come selettori css in data-target-hide
 * (in questo caso un elemento con id="targetHide").
 * -----------------------------------------------------
 * ESEMPIO 3:
 * Se nella pagina abbiamo un elemento:
 * <a href="#" class="toggleShowHideTarget" data-target-show="#targetShow">Clicca qui</a>
 * Cliccando sul link appena descritto verranno solamente mostrati gli elementi specificati come selettori css in data-target-show
 * (in questo caso un elemento con id="targetShow")
 * -----------------------------------------------------
 */

jQuery.fn.extend({
    toggleShowHideTarget: function() {
        // Verifica se gli elementi a cui si applica il metodo esistono nella pagina altrimenti non esegue alcuna istruzione
        if ($(this).length > 0) {
            // Cicla ogni elemento presente nel selettore
            return this.each(function() {
                // Agganciamo le azioni da eseguire al metodo
                $(this).click(function(e){
                    // Unbind del comportamento predefinito dell'elemento al click
                    e.preventDefault();
                    // Interrompe le altre azioni eventualmente collegate al click
                    e.stopImmediatePropagation();
                    var attrTargetShow = $(this).attr("data-target-show");
                    // Se viene specificato l'atrtributo data-target-show, istanzia nella variabile l'oggetto specificato nel selettore dell'attributo, altrimenti valorizza a null
                    var targetShow = (typeof attrTargetShow !== 'undefined' && attrTargetShow !== false)?$($(this).attr("data-target-show")):null;
                    var attrTargetHide = $(this).attr("data-target-hide");
                    // Se viene specificato l'atrtributo data-target-hide, istanzia nella variabile l'oggetto specificato nel selettore dell'attributo, altrimenti valorizza a null
                    var targetHide = (typeof attrTargetHide !== 'undefined' && attrTargetHide !== false)?$($(this).attr("data-target-hide")):null;
                    // Se l'attributo data-target-hide è stato specificato, allora esegui questo
                    // Prima nascondi elemento in data-target-hide e poi mostra elemento in data-target-show
                    if (typeof attrTargetHide != 'undefined' && attrTargetHide != false) {
                        // Nascondi target hide 'fast' (velocemente)
                        targetHide.fadeOut('fast',function(){
                            // Se l'attributo data-target-show è stato specificato, allora esegui
                            if (typeof attrTargetShow != 'undefined' && attrTargetShow != false) {
                                // Mostra target-show 'fast' (velocemente)
                                targetShow.fadeIn('fast');
                            }
                        });
                        // Altrimenti se è stato specificato solamente l'attributo data-target-show, esegui questo
                    } else if (typeof attrTargetShow != 'undefined' && attrTargetShow != false) {
                        // Mostra ciò che viene specificato in targetShow 'fast' (velocemente)
                        targetShow.fadeIn('fast');
                    }
                });
            });
        } else {
            return false;
        }
    }
});

$(function(){
    $(".toggleShowHideTarget").toggleShowHideTarget();
});