package com.anjilibey.ar

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var arrayView : Array<View>
    lateinit var bearRenderable:ModelRenderable
    lateinit var catRenderable:ModelRenderable
    lateinit var cowRenderable:ModelRenderable
    lateinit var dogRenderable:ModelRenderable
    lateinit var elephantRenderable:ModelRenderable
    lateinit var ferretRenderable:ModelRenderable
    lateinit var hippopotamusRenderable:ModelRenderable
    lateinit var horseRenderable:ModelRenderable
    lateinit var koala_bearRenderable:ModelRenderable
    lateinit var lionRenderable:ModelRenderable
    lateinit var reindeerRenderable:ModelRenderable
    lateinit var wolverineRenderable:ModelRenderable

    internal var selected = 1
    lateinit var arFragment:ArFragment

    override fun onClick(view: View?) {
        if (view!!.id == R.id.bear){
            selected = 1
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.cat){
            selected = 2
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.cow){
            selected = 3
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.dog){
            selected = 4
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.elephant){
            selected = 5
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.ferret){
            selected = 6
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.hippopotamus){
            selected = 7
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.horse){
            selected = 8
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.koala_bear){
            selected = 9
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.lion){
            selected = 10
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.reindeer){
            selected = 11
            mysetBackground(view!!.id)
        }
        else if (view!!.id==R.id.wolverine){
            selected = 12
            mysetBackground(view!!.id)
        }
    }

    private fun mysetBackground(id: Int) {
        for(i in arrayView.indices){
            if(arrayView[i].id == id){
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"))
            }
            else{
                arrayView[i].setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupArray()
        setupClickListener()
        setupModel()
        arFragment = supportFragmentManager.findFragmentById(R.id.scene_from_fragment) as ArFragment
        arFragment.setOnTapArPlaneListener{hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel (anchorNode, selected)

        }
    }
    private fun createModel(anchorNode: AnchorNode, selected: Int) {
            if(selected == 1){
                val bear = TransformableNode(arFragment.transformationSystem)
                bear.setParent(anchorNode)
                bear.renderable = bearRenderable
                bear.select()
            }
    }

    private fun setupModel() {
        ModelRenderable.builder()
            .setSource(this, R.raw.bear)
            .build()
            .thenAccept { modelRenderable -> bearRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load bear model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.cat)
            .build()
            .thenAccept { modelRenderable -> catRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load cat model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.cow)
            .build()
            .thenAccept { modelRenderable -> cowRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load cow model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.dog)
            .build()
            .thenAccept { modelRenderable -> dogRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load dog model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.elephant)
            .build()
            .thenAccept { modelRenderable -> elephantRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load elephant model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.ferret)
            .build()
            .thenAccept { modelRenderable -> ferretRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load ferret model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.hippopotamus)
            .build()
            .thenAccept { modelRenderable -> hippopotamusRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load hippopotamus model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.horse)
            .build()
            .thenAccept { modelRenderable -> horseRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load horse model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.koala_bear)
            .build()
            .thenAccept { modelRenderable -> koala_bearRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load koala model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.lion)
            .build()
            .thenAccept { modelRenderable -> lionRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load lion model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.reindeer)
            .build()
            .thenAccept { modelRenderable -> reindeerRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load reindeer model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this, R.raw.wolverine)
            .build()
            .thenAccept { modelRenderable -> wolverineRenderable = modelRenderable }
            .exceptionally { throwable ->
                Toast.makeText(
                    this@MainActivity,
                    "unable to load wolverine model",
                    Toast.LENGTH_SHORT
                ).show()
                null
            }
    }

    private fun setupClickListener() {
        for (i in arrayView.indices){
            arrayView[i].setOnClickListener(this)
        }
    }

    private fun setupArray() {
        arrayView = arrayOf(
            bear,
            cat,
            cow,
            dog,
            elephant,
            ferret,
            hippopotamus,
            horse,
            koala_bear,
            lion,
            reindeer,
            wolverine
            )
    }
}