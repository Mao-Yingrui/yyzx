  if (method === 'post') {
    config.headers['Content-Type'] = 'application/json'
    config.data = params
  } else {
    config.params = params
  }