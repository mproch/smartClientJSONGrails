package pl.touk.mproch

import grails.converters.*

class SampleController {

	def sampleService
	def summary = {
	     jsonRender(params, sampleService."${params.method}"(params))
	}
	def jsonRender = { params, json -> render "${params['callback']}(${[Result:json] as JSON})" }

}
