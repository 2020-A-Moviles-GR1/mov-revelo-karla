/**
 * Pokemon.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

    attributes: {
      nombre:{
        type:"string"
      },
      usuario:{             //Many to One en Pokemon.
        model:"usuario",    //referencia a usuario
        required:true       //opcional y depende de la logica de negocio
      },
      batalla:{
        model:"batalla",
        required:false       //opcional y depende de la logica de negocio      
      }
    },
  };